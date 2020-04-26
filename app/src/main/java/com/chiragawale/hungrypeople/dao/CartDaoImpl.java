package com.chiragawale.hungrypeople.dao;

import android.content.Context;
import android.util.Log;

import com.carteasy.v1.lib.Carteasy;
import com.chiragawale.hungrypeople.data.model.FoodItem;

import java.util.Map;
import java.util.UUID;

public class CartDaoImpl implements CartDao {
    @Override
    public void addToCart(FoodItem foodItem, Context context) {
        Carteasy cs = new Carteasy();
        String id = UUID.randomUUID().toString();
        cs.add(id, "foodName", foodItem.getFoodName());
        cs.add(id, "foodPrice", foodItem.getFoodPrice());
        cs.add(id, "foodItemId", foodItem.getFoodItemID());
        cs.commit(context);
        cs.persistData(context, true);
        Log.e("GET","ADDED");
    }

    @Override
    public void clearCart(Context context) {

    }

    @Override
    public void removeItemFromCart(String id, Context context) {

    }

    @Override
    public void getAllItemsFromCart(Context context) {
        Map<Integer, Map> data;
        Carteasy cs = new Carteasy();
        data = cs.ViewAll(context);

        for (Map.Entry<Integer, Map> entry : data.entrySet()) {
            //get the Id
            Log.e("Key: ",entry.getKey().toString());
            Log.e("Value: ",entry.getValue().toString());
            //Get the items tied to the Id
            Map<String, String> innerdata = entry.getValue();
            for (Map.Entry<String, String> innerentry : innerdata.entrySet()) {
                Log.e("Inner Key: ",innerentry.getKey());
                Log.e("Inner Value: ",innerentry.getValue());
            }
        }
    }
//        FoodItem foodItem = new FoodItem("asd","momo","23","descirp");
//        App.cartDao.addToCart(foodItem,getApplicationContext());
//        App.cartDao.addToCart(foodItem,getApplicationContext());
//        App.cartDao.addToCart(foodItem,getApplicationContext());
//        App.cartDao.getAllItemsFromCart(getApplicationContext());

}
