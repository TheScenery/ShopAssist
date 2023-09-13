<script setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'

const workspaces = ref([
  { id: '1', name: 'workspace1' },
  { id: '2', name: 'workspace2' },
  { id: '3', name: 'workspace2' },
  { id: '4', name: 'workspace2' },
  { id: '5', name: 'workspace2' },
])

</script>

<template>
  <div class='workspaces-container'>
    <el-button type='primary' :icon='Edit' class='create-workspace-button'>{{ $t('workspaces.create') }}</el-button>
    <div class='workspaces-list-container'>
      <el-space wrap size='large'>
        <el-card v-for='workspace in workspaces' :key='workspace.id' class='workspace-container'>
          {{ workspace.name }}
        </el-card>
      </el-space>
    </div>
  </div>
</template>

<style scoped lang='scss'>
.workspaces-container {
  padding: 2rem 10rem;
  width: 100%;

  .create-workspace-button {
    width: 10rem;
  }

  .workspaces-list-container {
    padding: 2rem 0;

    .workspace-container {
      width: 15rem;
    }
  }
}
</style>