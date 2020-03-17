package com.dsp.web.model.admin;


public class SocketMsg {
    /* 消息来源sid */
    public String fromSID;
    /* 消息目标sid */
    public String toSID;
    /* 消息类型 */
    public String type;
    /* 消息体 */
    public String msg;
    /* 消息数据 */
    public String data;

    /* 房主sid */
    public Boolean isHomer;



    public String state="true";

    public static String ALL_COUNT="ALL_COUNT";//当前房间总数
    public static String QUEUE_STATE="QUEUE_STATE";//队列状态，有，无
    public static String INTO_GAME_COUNT="INTO_GAME_COUNT";//游戏中数量
    public static String INTO_MATCHING="INTO_MATCHING";//进入匹配
    public static String INTO_PREPARE="INTO_PREPARE";//进入准备中
    public static String INTO_GAME="INTO_GAME";//进入游戏
    public static String FRESH_TARGET_SCORE="FRESH_TARGET_SCORE";//刷新对方分数
    public static String GAME_OVER="GAME_OVER";//结束游戏
    public static String OUT_GAME="OUT_GAME";//退出游戏
    public static String CLOSE="CLOSE";//退出页面

    public String getFromSID() {
        return fromSID;
    }

    public void setFromSID(String fromSID) {
        this.fromSID = fromSID;
    }

    public String getToSID() {
        return toSID;
    }

    public void setToSID(String toSID) {
        this.toSID = toSID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getHomer() {
        return isHomer;
    }

    public void setHomer(Boolean homer) {
        isHomer = homer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static String getAllCount() {
        return ALL_COUNT;
    }

    public static void setAllCount(String allCount) {
        ALL_COUNT = allCount;
    }

    public static String getQueueState() {
        return QUEUE_STATE;
    }

    public static void setQueueState(String queueState) {
        QUEUE_STATE = queueState;
    }

    public static String getIntoGameCount() {
        return INTO_GAME_COUNT;
    }

    public static void setIntoGameCount(String intoGameCount) {
        INTO_GAME_COUNT = intoGameCount;
    }

    public static String getIntoMatching() {
        return INTO_MATCHING;
    }

    public static void setIntoMatching(String intoMatching) {
        INTO_MATCHING = intoMatching;
    }

    public static String getIntoPrepare() {
        return INTO_PREPARE;
    }

    public static void setIntoPrepare(String intoPrepare) {
        INTO_PREPARE = intoPrepare;
    }

    public static String getIntoGame() {
        return INTO_GAME;
    }

    public static void setIntoGame(String intoGame) {
        INTO_GAME = intoGame;
    }

    public static String getFreshTargetScore() {
        return FRESH_TARGET_SCORE;
    }

    public static void setFreshTargetScore(String freshTargetScore) {
        FRESH_TARGET_SCORE = freshTargetScore;
    }

    public static String getGameOver() {
        return GAME_OVER;
    }

    public static void setGameOver(String gameOver) {
        GAME_OVER = gameOver;
    }

    public static String getOutGame() {
        return OUT_GAME;
    }

    public static void setOutGame(String outGame) {
        OUT_GAME = outGame;
    }

    public static String getCLOSE() {
        return CLOSE;
    }

    public static void setCLOSE(String CLOSE) {
        SocketMsg.CLOSE = CLOSE;
    }
}

