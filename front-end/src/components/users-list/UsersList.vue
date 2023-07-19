<script setup>
import ConfigurableTable from '../configurable-table/ConfigurableTable.vue'
const tableData = [
  {
    code: 'U00001',
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    code: 'U00002',
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    code: 'U00003',
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    code: 'U00004',
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles'
  }
]
const config = [
  { prop: 'code', label: '用户编码' },
  { prop: 'name', label: '名称' },
  { prop: 'date', label: '生日' },
  { prop: 'address', label: '地址' }
]
</script>
<template>
  <ConfigurableTable :data="tableData" :config="config"></ConfigurableTable>
</template>
