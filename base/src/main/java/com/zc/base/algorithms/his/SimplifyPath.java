package com.zc.base.algorithms.his;

public class SimplifyPath {

    /**
     * /../
     * /a/./b/..//../c/
     * 特殊情况  ..  .  //
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        String realPath = "";
        String[] names = path.split("/");
        for (String name : names) {
            if(!"".equals(name) && !".".equals(name)){
                if("src/test".equals(name)){
                    if(realPath.length() != 0){
                        // 不是根目录
                        realPath = realPath.substring(0, realPath.lastIndexOf("/"));
                    }
                }else {
                    realPath = realPath + "/" + name;
                }
            }
        }
        if(realPath.length() == 0){
            realPath = "/";
        }

        return realPath;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String path = "/../";
        System.out.println(simplifyPath.simplifyPath(path));
    }

}
