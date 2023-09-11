<script setup>

import TopHeader from '@/components/header/TopHeader.vue';
</script>

<template>
  <el-container>
    <el-header>
      <TopHeader />
    </el-header>
    <el-container>
      <router-view />
    </el-container>
  </el-container>
</template>

<style scoped lang='scss'>

</style>