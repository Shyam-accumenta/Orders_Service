package com.example.oderservice.ServiceImpl;

import com.example.oderservice.dtos.UserDto;
import com.example.oderservice.dtos.UserResponse;
import com.example.oderservice.exception.OrdersNotFoundException;
import com.example.oderservice.exception.UserNotFoundException;
import com.example.oderservice.model.Orders;
import com.example.oderservice.repository.OrdersRepository;
import com.example.oderservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest-template.user.url}")
    private String USER_SERVICE_URL;

    @Override
    public List<Orders> getProducts(long userMobileNumber) {
        UserResponse userResponse = restTemplate.getForObject(USER_SERVICE_URL + userMobileNumber, UserResponse.class);
        assert userResponse != null;
        if(userResponse.getObject()!=null){
            List<Orders> orders = this.ordersRepository.findOrdersByUserMobileNumber(userResponse.getObject().getUserId());
            if(orders.isEmpty()){
                throw new OrdersNotFoundException("Orders not found for user with mobile number: " + userMobileNumber);
            }
            return orders;
        }else {
            throw new UserNotFoundException("User not found with mobile number: " + userMobileNumber);
        }
    }

    @Override
    public List<Orders> getAll() {
        return this.ordersRepository.findAll();

    }

    @Override
    public String addOrUpdateOrders(Orders orders, long userMobileNumber) {
        UserResponse userResponse = restTemplate.getForObject(USER_SERVICE_URL + userMobileNumber, UserResponse.class);
        assert userResponse != null;
        if(userResponse.getObject()==null){
            throw new UserNotFoundException("User not found with mobile number: " + userMobileNumber);
        }
        orders.setUserId(userResponse.getObject().getUserId());
        this.ordersRepository.save(orders);
        return "Order Placed for User..!";
    }

}













