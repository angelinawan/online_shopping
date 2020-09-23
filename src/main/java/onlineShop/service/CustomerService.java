package onlineShop.service;

import onlineShop.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import onlineShop.dao.CustomerDao;
import onlineShop.model.Customer;

@Service // relate to business logic
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.getUser().setEnabled(true);
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String email) {
        return customerDao.getCustomerByEmail(email);
    }
}
