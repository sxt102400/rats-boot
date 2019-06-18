const path = require("path");
function resolve(dir) {
  return path.join(__dirname, dir);
}

module.exports = {
  chainWebpack: config => {
    config
      .plugin("env")
      .use(require.resolve("webpack/lib/ProvidePlugin"), [
        { 
          jQuery: "jquery",
          $: "jquery" 
        }
        
      ]);

    config.plugin("html").tap(args => {
      args[0].minify = false;
      return args;
    });

    config.resolve.alias
      .set("@", resolve("src"))
      .set("static", resolve("../static"));
      
    config.toString();
  },
  devServer: {
    disableHostCheck: true,
    proxy: {
      "/api": {
        target: "http://127.0.0.1:18080",
        changeOrigin: true,
        pathRewrite: { "^/api": "/api" }
      }
    }
  }
};
