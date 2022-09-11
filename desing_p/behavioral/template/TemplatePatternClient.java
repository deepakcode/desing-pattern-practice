package com.practice.desing_p.behavioral.template;

class TemplatePatternClient
{
    public static void main(String[] args)
    {
        OrderProcessTemplate netOrder = new OnlineOrder();
        netOrder.processOrder(true);

        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}
