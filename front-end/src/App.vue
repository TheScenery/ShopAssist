<script setup>
import { RouterView } from 'vue-router';
</script>

<template>
  <el-container class='app-main-layout'>
    <RouterView />
  </el-container>
</template>

<style scoped lang='scss'>
.app-main-layout {
  height: 100%;
}
</style>
