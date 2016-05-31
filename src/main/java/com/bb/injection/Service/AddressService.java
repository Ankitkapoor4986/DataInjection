package com.bb.injection.Service;

import com.bb.injection.dao.AddressDao;

import java.util.List;

/**
 * Created by ankit on 31/5/16.
 */
public class AddressService {

    private static AddressService addressService =new AddressService();
    private AddressService(){}
    public static AddressService getInstance(){
        return addressService;
    }
    //TODO UsersId are fixed right now make them dynamic
    public void updateAddress(){
        AddressDao addressDao=new AddressDao();
        List<Long> addressIds=addressDao.getAddressId();
        addressDao.updateAddress(addressIds);
    }
}
