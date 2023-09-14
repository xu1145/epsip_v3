<template>
  <div class="wrapper">
    <el-container>
      <!-- 头部导航 -->
      <el-header class="homeHeader">
        <div class="title">企业进销存平台</div>
      </el-header>

      <el-container>
        <!-- 侧边菜单 -->
        <el-aside width="200px">
          <el-menu router
                   default-active="3"
                   class="el-menu-vertical-demo"
                   @open="handleOpen"
                   @close="handleClose">

            <el-menu-item>
              <i class="el-icon-menu"></i>
              <span slot="title">主页</span>
            </el-menu-item>

            <!--            <el-menu-item>-->
            <!--              <i class="el-icon-menu"></i>-->
            <!--              <span slot="title">操作指南</span>-->
            <!--            </el-menu-item>-->

            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>信息查询</span>
              </template>
              <el-menu-item index="/orderList">订单显示</el-menu-item>
              <el-menu-item index="/customerList">所有客户</el-menu-item>
              <el-menu-item index="/warehouseList">查看仓库</el-menu-item>
              <el-menu-item index="/employeeList">所有员工</el-menu-item>
              <el-menu-item index="/productListQuery">分仓查询</el-menu-item>
            </el-submenu>

            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>信息录入</span>
              </template>
              <el-menu-item index="/customerAdd">添加客户信息</el-menu-item>
              <el-menu-item index="/productUpdate">商品定价</el-menu-item>
              <!--              <el-menu-item>添加仓库</el-menu-item>-->
              <el-menu-item index="/positionUpdate">设定职位</el-menu-item>
              <el-menu-item index="/employeeAdd">添加员工</el-menu-item>
              <el-menu-item index="/productAdd">添加货品</el-menu-item>
            </el-submenu>

            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>订单处理</span>
              </template>
              <!--              <el-menu-item>开销货单</el-menu-item>-->
              <!--              <el-menu-item>审核订单</el-menu-item>-->
              <!--              <el-menu-item>开单收银</el-menu-item>-->
              <el-menu-item index="/productRetail">零售收银</el-menu-item>
              <el-menu-item index="/orderCancel">整单退货</el-menu-item>
              <el-menu-item index="/orderAllow">配货</el-menu-item>
            </el-submenu>

            <el-submenu index="6">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>统计盘点</span>
              </template>
              <el-menu-item index="/orderStat">销售统计</el-menu-item>
              <!--              <el-menu-item>资金统计</el-menu-item>-->
              <!--              <el-menu-item>内存盘点</el-menu-item>-->
              <el-menu-item index="/productCheck">库存盘点</el-menu-item>
              <!--              <el-menu-item>库存统计</el-menu-item>-->
            </el-submenu>

            <el-submenu index="7">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>货品管理</span>
              </template>
              <!--              <el-menu-item>调配库存</el-menu-item>-->
              <el-menu-item index="/productInfoAdd">进货</el-menu-item>
            </el-submenu>

            <el-menu-item index="8">
              <i class="el-icon-menu"></i>
              <span slot="title">Error Pages</span>
            </el-menu-item>

          </el-menu>
        </el-aside>

        <!-- 内容区域 -->
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Menu",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
};
</script>
<style scoped>
.homeHeader {
  background: #409eff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 15px;
  box-sizing: border-box;
}

.homeHeader .title {
  font-size: 30px;
  font-family: 楷体;
  color: white;
}
</style>
