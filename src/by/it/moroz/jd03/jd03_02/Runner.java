package by.it.moroz.jd03.jd03_02;

import by.it.moroz.jd03.jd03_02.beans.Order;
import by.it.moroz.jd03.jd03_02.beans.Role;
import by.it.moroz.jd03.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();

        User user = new User(0, "TestUser", "TestPassword", "TestEmail", "TestPAddress",
                "TestName", "TestSurname", 447569453, 2);
        if (userCRUD.createUser(user))
            System.out.println("CREATEGOODSFLOWER OK: " + user);
        user.setLogin("TestUserUpdate");
        if (userCRUD.updateUser(user))
            System.out.println("UPDATE OK: " + user);
        user = userCRUD.readUser(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (userCRUD.deleteUser(user))
            System.out.println("DELETE OK: " + user);

        RoleCRUD roleCRUD = new RoleCRUD();

        Role role = new Role(0, "TestRole");
        if (roleCRUD.createRole(role))
            System.out.println("CREATEGOODSFLOWER OK: " + role);
        role.setRole("TestRoleUpdate");
        if (roleCRUD.updateRole(role))
            System.out.println("UPDATE OK: " + role);
        role = roleCRUD.readRole(role.getId());
        if (role != null)
            System.out.println("READ OK: " + role);
        if (roleCRUD.deleteRole(role))
            System.out.println("DELETE OK: " + role);

        OrderCRUD orderCRUD = new OrderCRUD();

        Order order = new Order(0, "TestName", 2, 35.5, 71, 2);
        if(orderCRUD.createOrder(order))
            System.out.println("CREATE OK: " + order);
        order.setCount(1);
        if(orderCRUD.updateOrder(order))
            System.out.println("UPDATE OK: " + order);
        order = orderCRUD.readOrder(order.getId());
        if(order!=null)
            System.out.println("READ OK: " + order);
        if(orderCRUD.deleteOrder(order))
            System.out.println("DELETE OK: " + order);


    }
}
