package vn.danhgia24h.umgr.services;

import vn.danhgia24h.umgr.models.User;

public interface AuthenticationProvider {
    User authenticate(String email, String password);
}
