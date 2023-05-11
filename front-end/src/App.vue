<script setup>
import { RouterView } from 'vue-router'
</script>

<template>
  <el-container class="common-layout">
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-container>
          <el-main><RouterView /></el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
</template>

<style scoped lang="scss">
.common-layout {
  height: 100%;
}
</style>
