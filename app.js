// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    //B2分支删除
  globalData: {
    userInfo: null
  }
})

  
  //B2分支增加


  //C4 - modified
