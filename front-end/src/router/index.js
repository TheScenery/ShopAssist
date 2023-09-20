import { createRouter, createWebHistory } from 'vue-router';
import { AuthRoutes } from '@/router/auth';
import FullLayout from '@/layout/FullLayout.vue';
import MainLayout from '@/layout/MainLayout.vue';
import { SystemRoutes } from '@/router/system';
import { WorkspaceRoute } from '@/router/workspace';
import PortalLayout from '@/layout/PortalLayout.vue';
import TestView from '@/views/TestView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: TestView
    },
    {
      path: '/auth',
      name: 'auth',
      component: FullLayout,
      children: [
        ...AuthRoutes
      ]
    },
    {
      path: '/',
      name: 'workspace',
      redirect: '/workspace',
      component: PortalLayout,
      children: [
        ...WorkspaceRoute
      ]
    },
    {
      path: '/app',
      component: MainLayout,
      name: 'app',
      redirect: '/user-management',
      children: [
        ...SystemRoutes
      ]
    }
  ]
});

export default router;
