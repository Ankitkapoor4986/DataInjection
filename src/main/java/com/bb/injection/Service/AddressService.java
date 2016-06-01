package com.bb.injection.Service;

import com.bb.injection.dao.AddressDao;
import com.bb.injection.model.Address;

import java.util.List;

/**
 * Created by ankit on 31/5/16.
 */
public class AddressService {
    private static AddressDao addressDao=AddressDao.getInstance();
    private static AddressService addressService =new AddressService();
    private AddressService(){}
    public static AddressService getInstance(){
        return addressService;
    }
    //TODO UsersId are fixed right now make them dynamic
    public void updateAddress(){

        List<Long> addressIds=addressDao.getAddressId();
        addressDao.updateAddress(addressIds);
    }

    public List<Address> getAddress(){
        return addressDao.getAddresses();
    }
}
