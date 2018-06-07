package vn.danhgia24h.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "application",
        ignoreUnknownFields = false
)
public class ApplicationProperties {

    private Activation activation;
    private Ldap ldap;

    public ApplicationProperties() {
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

    public Ldap getLdap() {
        return ldap;
    }

    public void setLdap(Ldap ldap) {
        this.ldap = ldap;
    }

    public static class Activation {
        private long expirePeriod;
        private boolean enableMail;

        public long getExpirePeriod() {
            return expirePeriod;
        }

        public void setExpirePeriod(long expirePeriod) {
            this.expirePeriod = expirePeriod;
        }

        public boolean isEnableMail() {
            return enableMail;
        }

        public void setEnableMail(boolean enableMail) {
            this.enableMail = enableMail;
        }
    }

    public static class Ldap {
        private boolean enabled;
        private String url = "";
        private String base = "";
        private String userDN = "";
        private String password = "";

        public Ldap() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getUserDN() {
            return userDN;
        }

        public void setUserDN(String userDN) {
            this.userDN = userDN;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
