package top.stackpop.composite;

public interface FileSystemNode {
    /**
     * 一些应用场景 ai生成
     *  GUI 组件树：如 Swing/JavaFX/Android 的界面组件（JComponent、Parent/Node），容器与控件统一渲染、统一事件派发。
        HTML/DOM/XML/JSON 节点树：org.w3c.dom.Node 等，统一遍历与读写节点；模板引擎/解析器对树统一处理。
        菜单/路由/站点地图：后台管理系统的多级菜单、前端路由表，统一渲染、统一权限判断、统一启用/禁用。
        组织架构/部门-员工：统一计算人数/预算、统一打印树，叶子是员工、组合是部门。
        商品分类/目录树：电商类目树，统一统计商品数量、价格区间聚合等。
        权限/资源树（RBAC 扩展）：菜单、按钮、API 作为资源树，统一授权检查/收敛展示。
        权限/资源树（RBAC 扩展）：菜单、按钮、API 作为资源树，统一授权检查/收敛展示。
        组织架构/部门-员工：统一计算人数/预算、统一打印组织树。
        菜单/路由/站点地图：统一渲染、统一权限控制、统一启用/禁用。
        GUI 组件树（Swing/JavaFX/Android）：统一渲染与事件分发。
        DOM/XML/JSON 节点树（如 org.w3c.dom.Node、Jackson JsonNode）：统一遍历、读写与渲染。
        文件系统：目录聚合文件大小、统一打印与遍历。
        表达式/语法树（AST）：统一计算、优化与代码生成（规则引擎、查询构建、模板引擎）。
        工作流/审批流：节点可包含子节点，统一推进、回退与统计。
        命令/宏命令：将多个命令组合成一个命令统一执行/撤销。
        报表分组/小计/汇总：分组节点聚合子明细指标，统一导出/渲染。
        商品类目/标签层级：统一统计、统一筛选与导航。
        监控指标/告警规则聚合：父节点聚合子指标，统一阈值判断与展示。
        前端组件/页面区块树：统一渲染与状态下发（SSR/微前端同理）。
        微服务 API 组合/聚合网关：聚合下游服务结果，统一为上游提供单一接口。
        权限策略/过滤器链分组：将策略按层级组合，统一执行策略与短路控制。
        评论/回复/帖子树：统一渲染、折叠与统计点赞数/回复数。
        构建任务/流水线（Gradle/Maven 插件树）：父任务汇总子任务状态与产物。
     * @return
     */

    String getName();

    long getSize();

    default void add(FileSystemNode node){
        throw new UnsupportedOperationException("Leaf can not add child");
    }

    default void remove(FileSystemNode node){
        throw new UnsupportedOperationException("Leaf cannot remove child");
    }

    default void print(String indent){
        System.out.println(indent + getName() + "("+ getSize()+"bytes)");
    }
} 
