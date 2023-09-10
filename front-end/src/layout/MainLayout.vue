<script setup>
import { RouterView } from 'vue-router';
import Header from '../components/header/TopHeader.vue';
import Menu from '../components/menu/LeftMenu.vue';
</script>

<template>
  <el-container>
    <el-header>
      <Header></Header>
    </el-header>
    <el-container>
      <el-aside width='200px'>
        <Menu />
      </el-aside>
      <el-container>
        <el-main class='sa-main-content'>
          <RouterView />
        </el-main>
      </el-container>
    </el-container>
  </el-container>
</template>

<style scoped lang='scss'>
.sa-main-content {
  padding: 24px;
}
</style>
