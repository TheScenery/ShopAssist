<script setup>
import { RouterView } from 'vue-router'
import Header from './components/header/Header.vue'
import Menu from './components/menu/Menu.vue';
</script>

<template>
  <el-container class="common-layout">
      <el-header>
        <Header></Header>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <Menu/>
        </el-aside>
        <el-container>
          <el-main class="sa-main-content">
            <RouterView />
          </el-main>
        </el-container>
      </el-container>
    </el-container>
</template>

<style scoped lang="scss">
.common-layout {
  height: 100%;
  .sa-main-content {
    padding: 24px;
  }
}
</style>
