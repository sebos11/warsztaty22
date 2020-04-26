package pl.coderslab.app;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.models.User;




public class readUsers {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        User[] users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        /*User user1 = new User("user2xxx","user2xxxemail","2dupa3",2);
       userDao.create(user1);
        User user2 = userDao.read(6);
        System.out.println(user2.toString())*/

        /*User user3 = new User("user2xx","email2xxx","dupa2x",1);
        user3.setId(user2.getId());
        userDao.update(user3);
        user2 = userDao.read(2);
        System.out.println(user2.toString());
        userDao.delete(1);*/
        /*Group group = new Group("dupa");
        GroupDao groupDao = new GroupDao();
        groupDao.create(group);*/


            }
}
