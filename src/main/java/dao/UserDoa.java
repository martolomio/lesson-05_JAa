package dao;

import domain.User;
import sheard.AbstractCrud;
//user doa
public interface UserDoa extends AbstractCrud<User> {
    User getUserByEmail(String email);
}
