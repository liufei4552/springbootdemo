package com.java.utils;

import org.apache.log4j.Logger;

public class LogUtil {

   /* private static Logger playerLogger = Logger.getLogger("playerLog");*/
    /**
     * 后台日志输出
     */
    private static Logger gmLogger = Logger.getLogger("gmLog");
    /**
     * 后台记录邮件
     */
    private static Logger maiLogger = Logger.getLogger("mail");
	/**
	 * 后台错误日志错误
	 */
	private static Logger gmError=Logger.getLogger("file");
   /* public static void getPlayerLog(String log) {

        playerLogger.info(log);
    }*/

    public static void getGMLog(String log) {
        gmLogger.info(log);
    }
    public static void getMail(Object Object) {
		maiLogger.info(Object);
    }
    public static void getError(String string){
    	gmError.error(string);
	}

}
