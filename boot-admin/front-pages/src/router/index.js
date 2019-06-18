/**
 * Vue Router
 *
 * @library
 *
 * https://router.vuejs.org/en/
 */

// Lib imports
import Vue from 'vue'
import VueAnalytics from 'vue-analytics'
import Router from 'vue-router'
import Meta from 'vue-meta'

// Routes
import menus from './menu'

function route (path) {
  if(path.children && path.children.length ) {
      path.children = path.children.map(path => route(path)).concat();
      console.log("children___" + path.name, path.children)
  }  
  if( path.view) {
    console.log("path.name=" + path.name, path.view)
    return {
      name: path.name || path.view,
      path: path.path,
      component: (resovle) => import(
        `@/views/${path.view}.vue`
      ).then(resovle),
      view: path.view,
      children: path.children
    }
  } else {
    return path
  }
}

function routeMap() {
  let routers = [];
  routers=routers.concat( menus.toolBarMenu.map(path => route(path)));
  menus.drawerMenu.forEach( item=> {
    item = item.map(path => route(path))
    routers=routers.concat( item);
  })
 
  return routers;
}

Vue.use(Router)

let psth2 = routeMap();

console.log("psth2",psth2 )

// Create a new router
const router = new Router({
  mode: 'history',
  routes: routeMap(),
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    }
    if (to.hash) {
      return { selector: to.hash }
    }
    return { x: 0, y: 0 }
  }
})

Vue.use(Meta)

// Bootstrap Analytics
// Set in .env
// https://github.com/MatteoGabriele/vue-analytics
if (process.env.GOOGLE_ANALYTICS) {
  Vue.use(VueAnalytics, {
    id: process.env.GOOGLE_ANALYTICS,
    router,
    autoTracking: {
      page: process.env.NODE_ENV !== 'development'
    }
  })
}

export default router
