import Vue from 'vue'
import Router from 'vue-router'


import Menu from "@/components/Menu";
import CustomerList from "@/components/customer/CustomerList";
import CustomerAdd from "@/components/customer/CustomerAdd";
import EmployeeAdd from "@/components/employee/EmployeeAdd";
import EmployeeList from "@/components/employee/EmployeeList";
import PositionUpdate from "@/components/employee/PositionUpdate";
import ProductAdd from "@/components/product/ProductAdd";
import ProductUpdate from "@/components/product/ProductUpdate";
import WarehouseList from "@/components/warehouse/WarehouseList";
import ProductInfoAdd from "@/components/product/ProductInfoAdd";
import ProductListQuery from "@/components/product/ProductListQuery";
import ProductCheck from "@/components/product/ProductCheck";
import OrderList from "@/components/order/OrderList";
import OrderCancel from "@/components/order/OrderCancel";
import OrderAllow from "@/components/order/OrderAllow";
import OrderStat from "@/components/order/OrderStat";
import ProductRetail from "@/components/product/ProductRetail";
import Login from "@/components/Login.vue";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      name:'Login',
      component:Login,
    },
    {
      path: '/Menu',
      name: 'Menu',
      component: Menu,
      children: [
        {
          path: '/customerList',
          name: CustomerList,
          component: CustomerList,
        },{
          path: '/customerAdd',
          name: CustomerAdd,
          component: CustomerAdd,
        },{
          path: '/employeeAdd',
          name: EmployeeAdd,
          component: EmployeeAdd,
        },{
          path: '/employeeList',
          name: EmployeeList,
          component: EmployeeList,
        },{
          path: '/positionUpdate',
          name: PositionUpdate,
          component: PositionUpdate,
        },{
          path: '/productAdd',
          name: ProductAdd,
          component: ProductAdd,
        },{
          path: '/productUpdate',
          name: ProductUpdate,
          component: ProductUpdate,
        },{
          path: '/warehouseList',
          name: WarehouseList,
          component: WarehouseList,
        },{
          path: '/productInfoAdd',
          name: ProductInfoAdd,
          component: ProductInfoAdd,
        },{
          path: '/productListQuery',
          name: ProductListQuery,
          component: ProductListQuery,
        },{
          path: '/productCheck',
          name: ProductCheck,
          component: ProductCheck,
        },{
          path: '/orderList',
          name: OrderList,
          component: OrderList,
        },{
          path: '/orderCancel',
          name: OrderCancel,
          component: OrderCancel,
        },{
          path: '/orderAllow',
          name: OrderAllow,
          component: OrderAllow,
        },{
          path: '/orderStat',
          name: OrderStat,
          component: OrderStat,
        },{
          path: '/productRetail',
          name: ProductRetail,
          component: ProductRetail,
        },
      ]
    }
  ]
})
