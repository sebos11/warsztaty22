package pl.coderslab.app;

import pl.coderslab.dao.GroupDao;

import pl.coderslab.models.Group;



public class readGroups {
    public static void main(String[] args) {
        GroupDao groupDao = new GroupDao();
       /* Group group = new Group();
        group = groupDao.read(3);
        group.setGroupName("jeszcze bladsza");
        groupDao.update(group);
        System.out.println(group.toString());
        groupDao.delete(3);*/
        /*System.out.println(group.toString());*/
        Group[] groups;
        groups = groupDao.findAll();
        for (Group group : groups) {
            System.out.println(group.toString());
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
        }
}
