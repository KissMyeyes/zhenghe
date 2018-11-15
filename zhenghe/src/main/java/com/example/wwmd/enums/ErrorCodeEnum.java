package com.example.wwmd.enums;

/**
 * 错误码枚举
 *
 * @author zzhao E-mail:bovenjoy@163.com
 * @version createTime:2015-11-16 下午17:21:55 v.1
 */
public enum ErrorCodeEnum {

    // ========================basic==10======================

    AGENT_NOT_EXIST("100001", "代理商不存在"),

    AGENT_DURG_NOT_EXIST("100002", "代理商药品库不存在"),

    DISPATCH_NOT_EXIST("100003", "商业公司信息不存在"),

    DRUG_NOT_EXIST("100004", "药品信息不存在"),

    FACTORY_NOT_EXIST("100005", "药厂信息不存在"),

    DRUG_IS_EXIST("100006", "药品信息已存在"),

    DELETE_HAS_NO_AUTH("100007", "没有删除权限"),

    DELETE_FAIL_FOR_CFG_EXIST("100008", "存在流向信息，删除失败"),

    DELETE_FAIL_FOR_STORAGE_EXIST("100009", "存在入库信息，删除失败"),

    FACTORY_NAME_IS_EXIST("100010", "药厂名称已存在"),

    FACTORY_CFDA_IS_EXIST("100011", "该CFDA对应的药厂已经存在"),

    DISPATCH_IS_EXIST("100012", "商业公司信息已经存在"),

    DRUG_ID_IS_NULL("100013", "请填写药品编码对应列数"),

    DRUG_NAME_IS_NULL("100014", "请填写药品名称对应列数"),

    DRUG_SPEC_IS_NULL("100015", "请填写规格对应列数"),

    FACTORY_NAME_IS_NULL("100016", "请填写生产企业对应列数"),

    DRUG_PRICE_IS_NULL("100017", "请填写单价对应列数"),

    DRUG_NUM_IS_NULL("100018", "请填写数量对应列数"),

    DATE_IS_NULL("100019", "请填写日期对应列数"),

    SERIAL_NO_IS_NULL("100020", "请填写销售单号对应列数"),

    AREA_NAME_IS_NULL("100021", "请填写区域名称对应列数"),

    ORDER_TYPE_IS_NULL("100022", "请填写单据类型对应列数"),

    ID_REFER_IS_USED("100023", "模版映射全部被占用，请联系平台管理员"),

    AUTH_NOT_EXIST("100024", "没有操作权限"),

    AGENT_NOT_EQ("100025", "代理商不一致"),

    DRUG_MEDICARE_DIRECTOR_IS_EXIST("100026", "医保数据已经存在"),

    HOSPITAL_INFO_NAME_IS_EXIST("100027", "该名称已经存在"),

    HOSPITAL_INFO_TYPE_NOT_AGENT("100028", "所属类型为代理商才能进行升级/忽略升级"),

    HOSPITAL_INFO_AGENT_NOT_EQ("100029", "所属代理商不匹配"),

    HOSPITAL_INFO_COMPANY_TYPE_ADMIN("100030", "医院所属平台无法进行删除"),

    PLEASE_LOGIN_AGAIN("100031", "请重新登录"),

    BATCH_NO_IS_NULL("100032", "请填写批号对应列数"),

    BASE_DRUG_TYPE_CODE_IS_EXIST("100033", "药品分类编码已存在"),

    BASE_DRUG_TYPE_CODE_ERROR("100034", "药品分类编码不合规"),

    BASE_DRUG_TYPE_NAME_IS_EXIST("100035", "药品分类名称已存在"),

    BASE_DRUG_TYPE_OLD_IS_NOT_EXIST("100036", "原药品分类记录不存在"),

    BASE_DRUG_TYPE_HAS_DRUG("100037", "该分类下有药品无法删除"),

    BASE_DRUG_TYPE_HAS_SUB_TYPE("100038", "该分类下有子分类无法删除"),

    BASE_DRUG_TYPE_IS_NOT_EXIST("100039", "药品分类记录不存在"),

    AGENT_HOSPITAL_IN_USED("100040", "该医院存在科室医生"),

    AGENT_HOSPITAL_ROOM_IN_USED("100041", "该科室存在医生"),

    ROOM_NAME_EXIST_IN_AGENT_HOSPITAL("100042", "该医院已存在同名科室"),

    ROOM_RECORD_NOT_EXIST("100043", "科室不存在"),

    MOBILE_EXIST_IN_ROOM("100044", "手机号在该科室已经存在"),

    DOCTOR_NOT_BELONG_TO_THIS_AGENT("100045", "该医生不属于当前账号代理商"),

    ROOM_NOT_BELONG_TO_THIS_AGENT("100046", "该科室不属于当前账号代理商"),

    AGENT_PLAN_HAS_EXIST("100047", "存在相同任务对象，任务类型，任务量统计方式的记录"),

    EXIST_SOME_DATA("100048", "存在相关数据，不能删除"),

    HOSPITAL_NAME_EXIST("100049", "医院名称已经存在"),

    DELETE_FAIL_FOR_FOLLOW_EXIST("100050", "存在流向信息，删除失败"),

    DELETE_FAIL_FOR_PLAN_EXIST("100051", "存在任务信息，删除失败"),

    HOSPITAL_TAG_REPEAT("100052", "医院类型不能重复"),

    CAN_NOT_UPDATE_AGENT_AREA_EXIST_USER("100053", "存在人员,无法修改代理商区域"),

    CAN_NOT_UPDATE_AGENT_AREA_EXIST_FLOW("100054", "存在流向,无法修改代理商区域"),

    AGENT_NAME_EXIST("100055", "代理商名称已存在"),

    EMOJI_NOT_SUPPORT("100056", "反馈内容只能输入中英文数字以及标点"),

    DRUG_HAS_USED_BY_AGENT("100057", "代理商正在使用该药品信息"),

    FACTORY_IS_BELONG_TO_DRUG("100058", "该药厂存在关联的药品信息"),

    SCIENCE_SAVE_ERROR("100059", "学术保存失败"),

    SCIENCE_UPLOAD_FILE_NAME_ERROR("100060", "文件名不能包含下划线'_'"),

    ADD_DRUG_TYPE_STATUS_ERROR("100061", "该药品已停用,不能添加规格"),

    ADD_DRUG_TYPE_MEDICINE_EXIST("100062", "添加规格失败,学术已存在"),

    DRUG_TYPE_LEVEL_LESS_THAN_3("100063", "请搜索三级及以下分类"),

    DRUG_TYPE_HAS_TOO_MANY_RESULTS("100064", "该名称存在多个分类信息，请输入编码共同确认分类"),

    DRUG_TYPE_HAS_BIND("100065", "当前药品有绑定分类无法删除"),

    CONTENT_NOT_STANDARD("100066", "只能输入中英文数字以及标点"),


    // ========================console==11======================
    ADMIN_NOT_EXIST("110001", "管理员不存在"),
    ADMIN_OLD_PASSWORD_ERROR("110002", "管理员原密码错误"),
    AGENT_APPLY_NOT_EXIST("110003", "代理商申请不存在"),
    MENU_NOT_EXIST("110004", "菜单不存在"),

    USER_ADVIDE_IS_DONE("110005", "反馈信息已经处理"),

    ADMIN_USERNAME_PASSWORD_ERROR("110006", "账号或密码错误"),

    ADMIN_STATUS_ERROR("110007", "管理员账号状态已冻结或已注销"),

    ADMIN_LEVEL_ERROR("110007", "管理员账号权限不足"),

    ADMIN_TYPE_AGENT("110008", "类型为代理商管理员才能操作"),

    ADMIN_BELONG_TO_SYSTEM_ADMIN("110009", "该管理员不允许删除"),

    ADMIN_STATUS_MUST_BE_LOGOFF("110010", "只有注销状态才能进行删除"),

    ADMIN_LEVEL_MUST_BE_LEVEL_ONE("110011", "被删除的管理员级别必须为一级"),

    ADMIN_LEVEL_MUST_BE_LEVEL_TWO("110011", "被删除的管理员级别必须小于一级"),

    DRUG_ADVICE_TIME_OUT("110012", "该药品反馈次数达上限"),

    ADMIN_OPERATOR_NOT_EQ("110013", "操作员不一致"),

    ZHI_YAO_DESCRIPTION_EXIST("110014", "该类型关于知药已存在,请直接编辑"),

    ZHI_YAO_DESCRIPTION_NOT_EXIST("110015", "关于知药未配置"),

    DRUG_ADVICE_TIME_OUT_10("110016", "今天反馈的信息已经收到啦，辛苦您了"),

    SICKNESS_ADVICE_TIME_OUT_10("110017", "今天反馈的信息已经收到啦，辛苦您了"),

    // ========================flow==12======================,

    AGENT_FLOW_UPLOAD_DATA_NOT_EXIST("120001", "导入数据不存在，请重新导入"),
    AGENT_FLOW_USER_NOT_ALLOT("120002", "小蜜蜂未分配"),
    BEGIN_TIME_BIGGER_THAN_END_TIME("120003", "开始时间大于结束时间"),
    DATE_TIME_BIGGER_THAN_ONE_YEAR("120004", "时间间隔大于一年"),
    AGENT_FLOW_NOT_BELONG_TO_THIS_AGENT("120005", "该流向不属于该代理商"),
    AGENT_FLOW_PAID_CAN_NOT_DELETE("120006", "删除流向中存在“已付款”状态流向，此状态只读不可操作"),
    AGENT_FLOW_NOT_EXIST("120007", "流向不存在"),

    AGENT_FLOW_HOSPITAL_NOT_CHOOSE("120005", "请先选择医院"),

    AGENT_FLOW_CFG_DATE_NOT_EXIST("120006", "业务分配开始时间最大允许提前天数未配置"),

    AGENT_FLOW_CFG_USER_EQ_USER("120007", "小蜜蜂1和招商经理不能为同一个"),

    AGENT_FLOW_DRUG_NOT_EXIST("120008", "代理商不存在该药品信息"),

    AGENT_FLOW_USER_MANAGE_NOT_EXIST("120009", "招商经理不存在"),

    AGENT_FLOW_DISPATCH_NOT_EXIST("120010", "商业公司信息不存在"),
    AGENT_FLOW_HOSPITAL_NOT_EXIST("120011", "医院信息不存在"),

    AGENT_FLOW_DATA_ERROR("120012", "流向信息数据异常"),

    AGENT_FLOW_CFG_NOT_EXIST("120013", "业务分配不存在"),

    AREA_LEVEL_NOT_SAME("120014", "区域不可跨级比较"),

    AGENT_FLOW_CFG_USER_EQ_USER2("120015", "小蜜蜂1和小蜜蜂2不能为同一个"),

    AGENT_FLOW_MANAGE_NOT_EXIST("120016", "管理经理不存在"),

    AGENT_FLOW_USER_2_NOT_EXIST("120017", "小蜜蜂2不存在"),

    AGENT_FLOW_CFG_USER_EQ_MANAGE("120018", "小蜜蜂1和管理人员不能为同一个"),

    AGENT_FLOW_HOSPITAL_EXIST("120019", "流向中存在该医院信息，无法删除"),

    AGENT_FLOW_PAY_USER_ERROR("120020", "批量付款中所选流向的小蜜蜂1必须相同"),

    AGENT_FLOW_PAY_USER_NULL("120021", "付款的流向中小蜜蜂1不能为空"),

    AGENT_FLOW_PAY_STATUS_ERROR("120022", "只有预付款状态的流向才能付款"),

    AGENT_FLOW_CFG_HOSPITAL_EXIST("120023", "业务分配中存在该医院信息，无法删除"),

    AGENT_HOSPITAL_REFER_EXIST("120024", "医院匹配关系中存在该医院信息，无法删除"),

    AGENT_HOSPITAL_PLAN_EXIST("120025", "计划任务中存在该医院信息，无法删除"),

    AGENT_HOSPITAL_SETTLE_EXIST("120026", "结算明细中存在该医院信息，无法删除"),

    AGENT_HOSPITAL_EXIST_RECORD("120027", "代理商医院库中存在该医院信息，无法删除"),

    NO_SELECTED_FLOW_INFO("120028", "请选择要操作的流向"),

    CFG_UPDATE_TIME_NOT_SAME("120029", "批量修改请保证医院的合作期限一致"),

    CFG_BATCH_UPDATE_NO_CHANGE("120030", "批量修改失败,数据未发生变化"),

    CFG_BATCH_UPDATE_OLD_NO_USER("120031", "批量修改失败,修改人员原数据无人员"),

    CFG_BATCH_UPDATE_NEW_NO_USER("120031", "人员为空,不能进行批量修改"),


    // ========================resource==13======================
    RESOURCE_NOT_EXIST("130001", "资源不存在"),

    ARTICLE_NOT_EXIST("130002", "文章不存在"),

    ARTICLE_ALREADY_PUBLISH("130003", "资讯已发布,本次编辑成功,请到原创库中再次编辑"),

    ARTICLE_PUBLISHING("130004", "资讯即将发布,请推迟发布时间"),

    ARTICLE_PUBLISH_TIME_ERROR("130005", "发布时间不能早于当前时间,请修改发布时间"),

    ARTICLE_PUBLISHING_BAN_ERROR("130006", "资讯即将发布,停用失败"),

    LATER_PUBLISH_NO_TIME("130007", "请填写发布时间"),

    NO_LONGEST_UPDATE_MINUTE("130008", "资讯发布前最后可编辑时间未配置"),

    PUBLISH_TIME_TOO_EARLY("130009", "发布时间过早,至少大于当前时间{0}分钟"),

    NO_CONTENT("130010", "内容不能为空"),

    THIRD_LABEL_NOT_CORRECT("130011", "三级标签只包含中英文数字，标签之间英文逗号隔开"),

    ARTICLE_NAME_EXIST("130012", "该资讯名称已存在"),

    ARTICLE_NAVIGATE_NAME_EXIST("130013", "该板块名称已存在"),

    ARTICLE_NAVIGATE_USING("130014", "该板块正被使用,删除将停用相关资讯"),

    ARTICLE_NAVIGATE_NUM_MAX("130015", "该板块内容最多添加21个分类，请进行删除或者修改"),

    NO_NAVIGATE_ID("130016", "请选择所属板块"),

    NAVIGATE_ID_NOT_EXIST("130017", "所属板块已被删除"),

    PUBLISH_TIME_ERROR("130018", "发布开始时间大于发布结束时间"),

    FLASH_DEFAULT_IMAGE_NEED_ONE("130019", "至少有一张快讯默认图为启用状态"),

    ARTICLE_PUBLISHING_CAN_NOT_UPDATE("130020", "资讯池发布中的资讯请到对应发布库中编辑"),

    ARTICLE_NAME_EXIST_IN_PUBLISHED("130021", "该资讯名称已在发布库存在"),

    SUP_TIME_LINE_NOT_EXIST("130022", "父时间线id不存在"),

    SUB_TIME_LINE_SHOW_TIME_ERROR("130023", "子时间线时间不能大于当前时间"),

    SUP_TIME_LINE_RECORD_NOT_EXIST("130024", "父时间线记录不存在"),

    SUP_TIME_LINE_NAME_EXIST("130025", "该时间线标题已存在"),

    SUP_HAVA_SUB_DELETER_ERROR("130026", "当前时间线有内容，确认删除?"),

    TIME_LINE_NAME_TOO_LONG("130027", "时间线标题过长"),

    TIME_LINE_TEXT_TOO_LONG("130028", "时间线纯文本内容过长"),

    TIME_LINE_NUM_TOO_BIG("130029", "最多添加50个时间线"),


    // ========================sms==14======================

    SEND_SMS_ERROR("140001", "短信发送失败"),

    VALID_CODE_SEND_TOO_QUICKLY("140002", "短信发送太频繁，请稍后再试"),

    NOTIFY_MODULE_NOT_EXIST("140003", "短信模版未配置"),

    VALID_CODE_NOT_EXIST("140004", "验证码错误 请重新输入"),

    VALID_CODE_ERROR("140005", "验证码错误 请重新输入"),

    VALID_CODE_SEND_TOO_MUCH("140006", "当前验证码操作频繁，请10分钟后再试"),

    // ========================storage==15======================
    ADMIN_TYPE_ERROR("150001", "admin类型错误"),

    NUM_BIGGER_THAN_BILL_NUM("150002", "开票张数不能大于发票数量"),

    RECEIVE_RECORD_IS_EXIST("150003", "存在查收记录，请先删除查收记录"),

    STORAGE_RECORD_IS_NOT_EXIST("150004", "不存在该库存信息"),

    RECEIVE_NUM_BIGGER_THAN_BILL_NUM("150005", "查收条数不能大于对应开票张数"),

    BILL_NUM_BIGGER_THAN_STORAGE_NUM("150006", "开票总数量不能大于实际入库数量"),
    // ========================sys==16======================

    SYSTEM_ERROR("160001", "系统异常 请联系管理员"),

    PARAM_ERROR("160002", "参数不正确"),

    PARAM_ERROR_NAME_LENGTH("160102", "昵称有点长，请缩短一点吧"),

    RECORD_NOT_EXIST("160003", "记录不存在"),

    RECORD_EXIST("160004", "记录已存在"),

    SYSTEM_PARAMS_NOT_DEPLOY("160005", "系统参数未配置"),

    FLODER_CREATE_FAILED("160006", "文件夹创建失败"),

    FILE_WRITE_FAILED("160007", "base64文件写入本地失败"),

    TIME_FORMAT_FAILED("160008", "时间类型格式错误"),

    AGENT_APPLY_HAS_EXIST("160009", "您的申请已经提交过了，知药小客服会及时联系您的"),

    AREA_NOT_EXIST("160010", "区域不存在"),

    SYSTEM_PARAMS_NAME_EXIST("1600011", "系统参数名已存在"),

    FILE_TYPE_NOT_IMAGE("1600012", "请选择你要上传的图片"),

    IMAGE_UPLOAD_BEYOND_MAX_SIZE("1600013", "上传图片数量超出最大限制"),

    SYSTEM_THIRD_PARTH_WX_TOKEN("1600014", "未配置微信公众号开发信息"),

    SYSTEM_THIRD_PARTH_WX_TOKEN_ERROR("1600015", "获取微信公共号开发信息失败"),

    ACTIVITY_AGENT_APPLY_HAS_EXIST("1600016", "您已经参加过该活动，无法再次申请"),

    AREA_SHORT_NAME_HAS_EXIST("1600017", "区域简称已经存在"),

    AREA_HAS_OPEN("1600018", "区域已经开启"),

    AREA_OPENED_NOT_MODIFY_SHORT_NAME("1600019", "已经开启的区域不允许修改简称"),

    AREA_SHORT_NAME_NOT_EMPTY("1600020", "开启区域前请输入简称"),

    AREA_NOT_OPEN("1600021", "区域不存在或该区域未开启"),

    FLOW_EXCEL_TITLE_EXTEND_NAME_NOT_EMPTY("1600022", "类型为必填时，异名库不能为空"),

    FLOW_EXCEL_TITLE_EXTEND_NAME_ERROR("1600023", "类型为必填时，异名库允许中文+括号+逗号分隔"),

    UPLOAD_FILE_THAN_3("1600024", "最多上传3个文件"),

    UPLOAD_FILE_ERROR("1600025", "文件上传失败"),

    FILE_DELETE_ERROR("1600026", "文件删除失败"),

    DATA_FORMATTER_ERROR("1600027", "数据格式错误"),

    IMAGE_UPLOAD_ERROR("1600028", "图片上传错误"),

    IMAGE_UPLOAD_TOO_BIG("1600029", "上传图片最大10M"),

    IMAGE_UPLOAD_TOO_BIG_5("1600030", "上传图片最大5M"),

    UPLOAD_FILE_THAN_10("1600031", "最多支持上传十个文件哦"),

    UPLOAD_FILE_TYPE_ERROE("1600032", "只支持上传word或pdf文件"),

    NO_FILE_CHOOSE("1600033", "请选择要上传的文件"),

    FILE_UPLOAD_TOO_BIG("1600034", "上传文件最大10M"),

    INVITED_CODE_PARAM_ERROR("1600035", "验证码只支持英文数字"),

    UPLOAD_FILE_TYPE_ERROE_4("1600035", "只支持上传word或pdf或word或ppt文件"),

    UPLOAD_FILE_THAN_5("1600036", "最多支持上传5个文件哦"),

    PNG_TYPE_TOO_BIG("1600037", "PNG类型图片不能大于1M"),

    // ========================user==17======================

    USER_MOBILE_PASSWORD_ERROR("170001", "手机号或密码错误"),

    USER_NOT_LOGIN("170002", "用户未登录或登录已过期"),

    USER_NOT_EXIST("170003", "用户不存在"),

    USER_OLD_PASSWORD_ERROR("170004", "原密码错误"),

    USER_MOBILE_NOT_EXIST("170005", "用户手机号未设置"),

    USER_OLD_PWD_EQ_NEW_PWD("170006", "新密码不能跟旧密码一样"),

    USER_TYPE_NOT_FULLTIME("170007", "用户非全职代理商平台下人员"),

    MOBILE_ERROR("170008", "请输入正确的手机号"),

    MOBILE_REGISTER("170009", "手机号已经注册，请登录"),

    PASSWORD_INPUT_ERROR("170010", "密码要求6-16位英文字母+数字"),

    USER_REGISTER_TYPE_ERROR("170011", "用户录入类型错误"),

    BANK_ACCOUNT_ERROR("170012", "银行卡卡号格式错误"),

    EMAIL_ADDRESS_ERROR("170013", "邮箱地址格式错误"),

    SEX_TYPE_ERROR("170014", "无效的性别类型"),

    USER_LOGOFF("170015", "用户已注销"),

    USER_PASSWORD_NOT_MATCH("170016", "两次密码不一致"),

    USER_CHANGE_PORTRAIT_ERROR("170017", "头像上传失败"),

    USER_NOT_BELONG_TO_AGENT("170018", "用户不属于当前代理商"),

    USER_NOT_CFG_AREA("170019", "用户未配置区域"),

    USER_STATUS_NOT_EXIST("170020", "用户状态错误"),

    USER_BIND_TYPE_IS_UNBIND("170021", "用户已经解绑，无法再解绑"),

    USER_BIND_ERROR_ON_TODAY("170022", "该用户当天存在解绑记录，无法绑定"),

    USER_UNBIND_ON_TODAY("170023", "该用户当天存在解绑记录，无法再解绑"),

    IDENTITY_NUMBER_ERROR("170024", "身份证号码格式错误"),

    AGENT_UESR_ALREADY_EXIST("170025", "已经录入过该用户信息"),

    AGENT_UESR_NOT_EXIST("170026", "代理商下该用户信息不存在"),

    BASE_UESR_NOT_EXIST("170027", "用户信息不存在"),

    USER_EXIST_FLOW_CFG_DATA("170028", "人员存在业务分配数据，不能删除"),

    USER_EXIST_FLOW_INFO_DATA("170029", "人员存在流向明细数据，不能删除"),

    USER_EXIST_PLAN_DATA("170030", "人员存在任务分配数据，不能删除"),


    USER_OPENID_NOT_FIND_ERROR("170101", "未注册的第三方帐号"),
    USER_TOKEN_NOT_EXIST("170102", "该接口需要登录，token为空"),
    USER_OPENID_EXIST_ERROR("170103", "已存在该第三方帐号"),
    MOBILE_REGISTER_TP_WX("170104", "当前手机号已绑定微信,请更换手机号"),
    MOBILE_REGISTER_TP_QQ("170105", "当前手机号已绑定QQ,请更换手机号"),
    MOBILE_REGISTER_TP_YD_MOBILE("170106", "移动授权获取手机号接口调用失败"),
    USER_PASSWORD_NULL_ERROR("170107", "用户密码未设置"),
    WX_OTHER_BINDED_ERROR("170108", "当前微信已绑定其他手机号，请更换。"),
    QQ_OTHER_BINDED_ERROR("170109", "当前QQ已绑定其他手机号，请更换。"),
    BASE_UESR_NAME_EXIST("170110", "用户名已存在"),

    // ========================activity==18======================

    ACTIVITY_OUT_OF_TIME("180001", "当前不在活动时间内"),

    ACTIVITY_HAS_ASSISTED("180002", "已经为该代理商助力"),

    ACTIVITY_NO_RESIDUE_DEGREE("180003", "您已经助力了5个代理商喽，已经很棒了"),

    NOT_ACTIVITY_AGENT_APPLY("180004", "该申请不是通过活动注册"),

    ACTIVITY_AGENT_APPLY_END("180005", "该申请助力时间已结束"),

    ACTIVITY_NOT_FOUND("180006", "活动不存在"),


    // ========================financeBaseInfo==19======================,
    BANK_ACCOUNT_EXIST("190001", "该银行卡号已存在相关财务基本信息"),

    FINANCE_BASE_INFO_IN_USED("190002", "该财务基本信息存在相关财务明细,不能删除"),

    FINANCE_BASE_INFO_NOT_EXIST("190003", "我方支出账号不存在"),

    FINANCE_BASE_NOT_BELONG_TO_ADMIN("190004", "只能操作自己公司的财务基本信息"),

    FINANCE_BASE_NOT_BELONG_TO_COMPANY("190005", "我方支出账号异常"),


    // =======================stock settle==20=======================
    STOCK_AMOUNT_LESS_THAN_SETTLE_AMOUNT("200001", "实际结算数量的总和不能大于该条入库的数量"),

    SETTLE_STATUS_EQUALS_SETTLED("200002", "编辑与删除操作时结算明细的而结算状态不能为已结算"),

    STOCK_CANNOT_BE_DELETE("200003", "不能删除非未结算状态的库存明细"),

    SETTLE_IS_EXIST("200004", "存在结算明细记录，请先删除结算明细记录"),

    SETTLE_IS_NOT_EXIST("200005", "结算明细记录不存在"),

    STOCK_IS_NOT_EXIST("200006", "库存明细记录不存在"),

    SETTLED_RECORD_CANNOT_BE_REPEATADD("200007", "已结算的结算明细不能被重复添加"),

    SETTLED_RECORD_CANNOT_BE_DELETE("200008", "已结算的结算明细不能被删除"),

    SETTLED_RECORD_CANNOT_BE_EDIT("200009", "已结算的结算明细不能被编辑"),

    UPLOAD_SETTLE_VOUCHER_IS_FAIL("200010", "上传结算凭证失败"),

    SETTLE_CART_IS_EMPTY("200011", "结算清单已被清空"),

    SETTLE_TICKETNO_IS_NOT_EQUAL("200012", "只有票号相同的结算明细才能加入到结算清单中,请检查票号"),

    STOCK_CANNOT_BE_EDIT("200015", "已结算状态下的库存明细不能被编辑"),

    // ========================financeBillInfo==21======================,
    FINANCE_BILL_INFO_NOT_EXIST("210001", "财务账单明细记录不存在"),

    FINANCE_BILL_INFO_CAN_NOT_DELETE("210002", "只有用户新增的财务账单明细允许删除"),

    FINANCE_BILL_INFO_NOT_BELONG_TO_ADMIN("210003", "只有用户新增的财务账单明细允许删除"),

    UPDATE_BILL_FINANCE_BASE_INFO_NOT_EXIST("210004", "我方账户记录不存在"),


    // =======================spreadInfo==22==========================
    SPREAD_INFO_TO_MANY_COPIES("220000", "哎呦！复制机会使用完啦，删除数据再复制吧"),

    SPREAD_INFO_ERROR_WHEN_COPY("220001", "复制推广数据时出错"),

    SPREAD_INFO_DELETE_NOT_EXIST("220002", "要删除的推广数据已经不存在"),

    SPREAD_INFO_DELETE_NOT_ALLOW("220003", "只能删除自己的推广数据"),

    SPREAD_INFO_ERROR_WHEN_DELETE("220004", "删除推广数据时出错"),

    SPREAD_INFO_VIEWS_NOT_ALLOW("220005", "只能查看自己的推广数据"),

    SPREAD_INFO_ERROR_WHEN_VIEW("220006", "查看推广数据出错"),

    SPREAD_INFO_ERROR_WHEN_ADD("220007", "新增推广数据出错"),

    SPREAD_INFO_ERROR_WHEN_UPDATE("220008", "编辑推广数据出错"),

    SPREAD_INFO_NOT_EXIST("220009", "推广记录不存在"),

    SPREAD_INFO_CANNOT_BE_COPIED("220010", "该条记录不能被复制"),

    SPREAD_INFO_COPY_NOT_ALLOW("220011", "只能复制自己的数据"),

    SPREAD_INFO_MISS_WATER_ICON("220012", "缺少水印图片资源"),

    SPREAD_INFO_OPERATE_WATER_ICON_ERROR("220013", "添加图片水印失败"),

    SPREAD_INFO_CAN_ONLY_SPREADED_ONCE("220014", "同一个人同一个药品只能推广一次"),
    // ========================drugBox==23======================,
    SPREAD_STAT_RECORD_NOT_EXIST("230001", "联系方式不存在"),

    DRUG_EXIST_IN_FOLLOW("230002", "药品已关注"),

    STAT_ID_NOT_BELONG_TO_SPREAD_ID("230003", "该联系方式不属于该条分享"),

    STAT_NOT_BELONG_TO_USER("230004", "只能操作自己的推广用户"),

    SPREAD_STAT_ERROE_WHEN_ADD("230004", "新增联系方式出错"),

    DRUG_FOLLOW_ERROE_WHEN_RESHEN("230005", "刷新关注药品信息出错"),

    DRUG_FOLLOW_ERROE_WHEN_ADD("230006", "新增药品关注出错"),

    DRUG_FOLLOW_ERROE_WHEN_DELETE("230007", "取消药品关注出错"),

    DRUG_FOLLOW_INFO_ERROR("230008", "关注药品信息有误"),

    MOBILE_EXIST_IN_SPREAD_STAT("2300010", "您已留过联系方式"),

    BASE_DRUG_DIRECTORY_EXIST("2400001", "基药目录已存在"),

    // ========================MyhHospital25======================
    MYH_HOSPITAL_CANNOT_BE_EMPTY("2500001", "医院编码不能为空"),

    MYH_AREA_CANNOT_BE_EMPTY("2500002", "区域编码不能为空"),

    MYH_DEPARTMENT_CANNOT_BE_EMPTY("2500003", "科室编码不能为空"),

    MYH_QUERY_SECONDLEVEL_DEPARTMENT_ERROR("2500004", "查询二级科室出错"),

    MYH_QUERY_HOSPITAL_DOCTOR_ERROR("2500005", "查询科室医生信息出错"),

    MYH_QUERY_DOCTOR_DUTY_ERROR("2500006", "查询科室医生排班信息出错"),

    MYH_DOCTOR_NAME_CANNOT_BE_EMPTY("2500007", "医生姓名不能为空"),

    BASE_DATA_IS_NOT_EXIST("2600001", "数据不存在"),

    BASE_SICKNESS_TYPE_HAS_EXIST("2700001", "当前编码不存在"),
    BASE_SICKNESS_TYPE_HAS_CHILD("2700002", "当前分类有子分类无法删除"),
    BASE_SICKNESS_TYPE_HAS_SAME("2700003", "当前分类名称已存在，请重新输入"),
    BASE_SICKNESS_NOT_EXIST_CAN_NOT_UPLOAD("2700004", "疾病不存在,上传失败"),
    BASE_SICKNESS_TYPE_HAS_BIND("2700005", "当前疾病有绑定分类无法删除"),
    BASE_SICKNESS_INFO_HAS_EXIST("2700006", "当前疾病不存在"),
    BASE_SICKNESS_INFO__HAS_SAME("2700007", "当前疾病名称已存在，请修改"),
    BASE_DRUG_TYPE_NOTES_HAS_SAME("2700008", "复制名称与原名称不能相同"),
    BASE_DRUG_TYPE_NOTES_CODE_HAS_SAME("2700009", "新增编码不能相同"),
    BASE_DRUG_TYPE_NOTES_CODE_HAS_EXIST("2700010", "当前编码不存在"),
    BASE_SICKNESS_INFO_HAS_SAME("2700011", "异名重复，请重新输入"),
    BASE_SICKNESS_ALIAS_HAS_OVER("2700012", "异名超出，请重新输入"),
    BASE_SICKNESS_ALIAS_HAS_NUM_OVER("2700013", "异名超出10个，请重新输入"),
    BASE_DRUG_TYPE_NOTES_UPDATE_SAME("2700014", "名称不能相同"),
    BASE_DRUG_TYPE_HAS_SAME("2800001", "当前分类名称已存在，请重新输入");

    private String code;

    private String name;

    private ErrorCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ErrorCodeEnum getByValue(String code) {
        if (code != null) {
            for (ErrorCodeEnum enu : values()) {
                if (enu.code.equals(code)) {
                    return enu;
                }
            }
        }
        return null;
    }
}