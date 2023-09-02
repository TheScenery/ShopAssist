import { createRouter, createWebHistory } from 'vue-router';
import { AuthRoutes } from '@/router/auth';
import FullLayout from '@/layout/FullLayout.vue';
import MainLayout from '@/layout/MainLayout.vue';
import { SystemRoutes } from '@/router/system';

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
      path: '/auth',
      name: 'auth',
      component: FullLayout,
      children: [
        ...AuthRoutes
      ]
    },
    {
      path: '/',
      component: MainLayout,
      name: 'main',
      redirect: '/user-management',
      children: [
        ...SystemRoutes
      ]
    }
  ]
});

export default router;
