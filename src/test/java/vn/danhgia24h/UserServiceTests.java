package vn.danhgia24h;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import vn.danhgia24h.core.errors.InvalidCredentialsException;
import vn.danhgia24h.umgr.models.Role;
import vn.danhgia24h.umgr.models.User;
import vn.danhgia24h.umgr.services.AuthService;
import vn.danhgia24h.umgr.services.RoleService;
import vn.danhgia24h.umgr.services.UserService;
import vn.danhgia24h.umgr.services.PrivilegeService;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Danhgia24hApplication.class)
@ActiveProfiles("test")
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PrivilegeService privilegeService;


	@Test
	public void testCRUDService() {
		User user = new User();
		user.setEmail("erp@vnpt-technology.vn");
		user.setPassword("123456");
		//test create
		user = userService.create(user);
		//test get by id
		User created = userService.get(user.getId());
		Assert.assertEquals("erp@vnpt-technology.vn",created.getEmail());

		//test update
		created.setEmail("newerp@vnpt-technology.vn");
		userService.update(created.getId(),created);
		User updated = userService.get(created.getId());
		Assert.assertEquals("newerp@vnpt-technology.vn",updated.getEmail());

		//test count
		Long count = userService.count();
		User anotherUser = new User();
		anotherUser.setEmail("erp1@vnpt-technology.vn");
		anotherUser.setPassword("123456");
		userService.create(anotherUser);
		Assert.assertEquals(count + 1,userService.count().longValue());
	}

	@Test
	public void testFindByEmail() {
		User user = new User();
		user.setEmail("erp@ssdc.vn");
		user.setPassword("123456");
		user = userService.create(user);
		User created = userService.findByEmail(user.getEmail());
		Assert.assertNotNull(created);
		Assert.assertEquals("erp@ssdc.vn",created.getEmail());
	}

	@Test
	public void tesAuthenticate() throws Exception {
		User user = new User();
		user.setEmail("auth@ssdc.vn");
		user.setPassword("123456");
		userService.create(user);
		Assert.assertNotNull(userService.authenticate("auth@ssdc.vn","123456"));
		try {
			user = userService.authenticate("auth@ssdc.vn","1234567");
		} catch(InvalidCredentialsException e) {
			//ok
		} catch(Exception e) {
			//ok
		}

//		authService.token("auth@ssdc.vn","123456");
	}

	@Test
	public void testRolePrivilege() {
		Role role1 = new Role();
		role1.setName("ROLE_TEST_1");
		role1.setDescription("test role1 1");
		role1 = roleService.create(role1);

		User user = new User();
		user.setEmail("testRolePrivilege@ssdc.vn");
		user.setPassword("123456");
		Set<Role> roles = new HashSet<>();
		roles.add(role1);
		user.setRoles(roles);
		user = userService.create(user);

		user = userService.findOneWithRoles(user.getId());
		Assert.assertEquals(1,user.getRoles().size());
	}
}
