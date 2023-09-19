<script setup>

defineProps({
  modelValue: Boolean,
  title: String
});
const emit = defineEmits(['update:modelValue', 'onOk']);

const onClose = () => {
  emit('update:modelValue', false);
};

const onConfirm = () => {
  emit('onOk');
  onClose();
};

</script>

<template>
  <el-dialog :visivle='modelValue' :title='title'>
    <slot></slot>
    <template #footer>
      <span class='dialog-footer'>
        <el-button @click='onClose'>{{ $t('cancel') }}</el-button>
        <el-button type='primary' @click='onConfirm'>
          {{ $t('confirm') }}
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped lang='scss'>

</style>