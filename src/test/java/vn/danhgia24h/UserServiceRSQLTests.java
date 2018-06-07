package vn.danhgia24h;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import vn.danhgia24h.core.rsql.CustomRsqlVisitor;
import vn.danhgia24h.umgr.models.User;
import vn.danhgia24h.umgr.repositories.UserRepository;

import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsNot.not;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Danhgia24hApplication.class)
@ActiveProfiles("test")
public class UserServiceRSQLTests {

    @Autowired
    UserRepository userRepository;

    private static User userERP;

    private static User userSSDC;

    @Before
    public void init() {
        initUser();
    }

    public void initUser()  {
        userERP = userRepository.findOneByEmailIgnoreCase("erp@vnpt-technology.vn");
        if(userERP == null) {
            userERP = new User();
            userERP.setEmail("erp@vnpt-technology.vn");
            userERP.setPassword("123456");
            userERP.setCreated(convertDateToLong("2017-07-11"));
            userRepository.save(userERP);
        }
        userSSDC = userRepository.findOneByEmailIgnoreCase("ssdc@vnpt-technology.vn");
        if(userSSDC == null) {
            userSSDC = new User();
            userSSDC.setEmail("ssdc@vnpt-technology.vn");
            userSSDC.setCreated(convertDateToLong("2017-07-12"));
            userSSDC.setPassword("123456");
            userRepository.save(userSSDC);
        }
    }

    @Test
    public void givenEmail_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email==erp@vnpt-technology.vn");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), isIn(emailList));
        Assert.assertThat(userSSDC.getEmail(), not(isIn(emailList)));
    }

    @Test
    public void givenOR_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email==erp@vnpt-technology.vn,email==ssdc@vnpt-technology.vn");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), isIn(emailList));
        Assert.assertThat(userSSDC.getEmail(), isIn(emailList));
    }

    @Test
    public void givenAND_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email==erp@vnpt-technology.vn;email==ssdc@vnpt-technology.vn");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), not(isIn(emailList)));
        Assert.assertThat(userSSDC.getEmail(), not(isIn(emailList)));
    }

    @Test
    public void givenEmailInverse_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email!=erp@vnpt-technology.vn");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), not(isIn(emailList)));
        Assert.assertThat(userSSDC.getEmail(), isIn(emailList));
    }

    @Test
    public void givenEmailPrefix_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email==erp*");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), isIn(emailList));
        Assert.assertThat(userSSDC.getEmail(), not(isIn(emailList)));
    }

    @Test
    public void givenListOfEmail_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email=in=(erp@vnpt-technology.vn,ssdc@vnpt-technology.vn)");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), isIn(emailList));
        Assert.assertThat(userSSDC.getEmail(), isIn(emailList));
    }

    @Test
    public void givenOutListOfEmail_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("email=out=(erp@vnpt-technology.vn)");
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), not(isIn(emailList)));
        Assert.assertThat(userSSDC.getEmail(), isIn(emailList));
    }

//    Greater than operator : =gt= or >
//    Greater than or equal to : =ge= or >=
    @Test
    public void givenMinCreated_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("created>"+convertDateToLong("2017-07-11"));
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), not(isIn(emailList)));
        Assert.assertThat(userSSDC.getEmail(), isIn(emailList));
    }

//    Less than : =lt= or <
//    Less than or equal to : =le= or ⇐
    @Test
    public void givenMaxCreated_whenGettingListOfUsers_thenCorrect() {
        Node rootNode = new RSQLParser().parse("created<"+convertDateToLong("2017-07-12"));
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        List<User> userList = userRepository.findAll(spec);

        List<String> emailList = new LinkedList<>();
        for (int i = 0; i < userList.size(); i++) emailList.add(userList.get(i).getEmail());

        Assert.assertThat(userERP.getEmail(), isIn(emailList));
        Assert.assertThat(userSSDC.getEmail(), not(isIn(emailList)));
    }

    public static long convertDateToLong(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Convert date time
        Date dateDf = null;
        try {
            dateDf = simpleDateFormat.parse(date);
        } catch(ParseException ex) {}
        return dateDf.getTime();
    }

}
