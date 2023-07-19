<script setup>
defineProps({
  config: Array,
  data: Array
})
</script>
<template>
  <el-table :data="data" border>
    <el-table-column v-for="columnConfig in config" :key="columnConfig.prop" :prop="columnConfig.prop" :label="columnConfig.label"></el-table-column>
  </el-table>
</template>
