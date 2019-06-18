export default {
  toolBarMenu: [
    {
      path: "/",
      redirect: "/dashboard",
      drawerMenuIndex: 0
    },
    {
      path: "/system",
      redirect: "/user-profile",
      drawerMenuIndex: 1
    },
    {
      path: "/demo",
      redirect: "/menuAdd",
      drawerMenuIndex: 2
    }
  ],
  drawerMenu: [
    [
      {
        text: "首页",
        icon: "",
        path: "home1",
        view: "Dashboard"
      },
      {
        text: "地图",
        roles: ["user"],
        path: "/home2",
        view: "Maps"
      },
      {
        text: "用户信息",
        path: "/home3",
        view: "UserProfile"
      },
      {
        text: "图标",
        path: "/home4",
        view: "Icons"
      }
    ],
    [
      {
        text: "操作管理",
        icon: "",
        path: "/menuList/operationList",
        view: "Maps"
      },
      {
        text: "用户管理",
        roles: ["user"],
        path: "/dashboard2",
        view: "Dashboard"
      },
      {
        text: "角色管理",
        path: "/user-profile2",
        view: "UserProfile"
      },
      {
        path: "/menuAdd",
        view: "Icons"
      }
    ],
    [
      {
        text: "11111",
        icon: "",
        path: "/menuList/operationList11",
        view: "Maps"
      },
      {
        text: "22222",
        roles: ["user"],
        path: "/dashboard3",
        view: "Dashboard"
      },
      {
        text: "33333",
        path: "/TableList3",
        view: "TableList"
      },
      {
        path: "/menuAdd4",
        view: "Icons"
      }
    ]
  ]
};
