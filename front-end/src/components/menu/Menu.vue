<script setup>
</script>
<template>
    <el-menu
    default-active="2"
    class="sa-menu-vertical"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
    <el-sub-menu index="1">
      <template #title>
        <span>系统管理</span>
      </template>
      <el-menu-item index="1-1">用户管理</el-menu-item>
        <el-menu-item index="1-2">权限管理</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<style scoped lang="scss">
.sa-menu-vertical {
    height: 100%;
}
</style>

