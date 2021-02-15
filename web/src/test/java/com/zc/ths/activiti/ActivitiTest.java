package com.zc.ths.activiti;

import com.zc.ths.CommonTest;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ActivitiTest extends CommonTest {

    private ProcessEngine processEngine;

    @Before
    public void initProcessEngie(){
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    /**
     * 部署流程定义
     * act_re_deployment、act_re_procdef、act_ge_bytearray
     */
    @Test
    public void testProcessEngine(){

        DeploymentBuilder builder = processEngine.getRepositoryService().createDeployment();
        builder.addClasspathResource("activity/leaveApply.bpmn20.xml");
        builder.addClasspathResource("activity/leaveApply.png");

        Deployment deploy = builder.deploy();
        System.out.println(deploy.getId());

    }

    /**
     * 查询流程定义
     * act_re_procdef
     */
    @Test
    public void testDefinitionQuery(){

        ProcessDefinitionQuery processDefinitionQuery = processEngine.getRepositoryService().createProcessDefinitionQuery();

        processDefinitionQuery.processDefinitionKey("leaveApply");
        processDefinitionQuery.orderByDeploymentId().desc();

        processDefinitionQuery.listPage(0, 10);
        List<ProcessDefinition> list = processDefinitionQuery.list();
        for (ProcessDefinition processDefinition : list) {
            System.out.println(processDefinition.getId());
        }
    }

    /**
     * 启动流程实例
     * 运行中的：ACT_RU_EXECUTION、ACT_RU_TASK、ACT_RU_IDENTITYLINK
     * 历史表：ACT_HI_PROCINST、ACT_HI_ACTINST、ACT_HI_TASKINST、ACT_HI_IDENTITYLINK
     * 关联流程定义ID：PROC_DEF_ID_
     */
    @Test
    public void testStartProcess(){
//        String processDefinitionId = "leaveApply:4:22504";
//        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processDefinitionId);

        /**
         * 通过key启动流程，如存在多个相同的key，会启动最后部署的流程
         */
        String processDefinitionKey = "leaveApply";
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
        System.out.println(processInstance.getId());
    }

    /**
     * 查询个人任务列表
     * ACT_RU_TASK，ACT_HI_TASKINST
     */
    @Test
    public void testQueryTask(){

        TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery();
        taskQuery.taskAssignee("张三");

        List<Task> list = taskQuery.list();
        for (Task task : list) {
            System.out.println(task.getId() + " ======= " + task.getName()); // 25004 ======= 一审
        }

    }

    /**
     * 办理任务
     */
    @Test
    public void testCompleteTask(){
        // 根据任务ID
        processEngine.getTaskService().complete("25004");
    }

    /**
     * 流程执行到下一步
     */
    @Test
    public void testToNext(){
        processEngine.getRuntimeService().signal("32501");

        TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery();
        taskQuery.deploymentId("22501");
        List<Task> list = taskQuery.list();
        for (Task task : list) {
            System.out.println(task.getId() + " ======= " + task.getName()); // 25004 ======= 一审
        }
    }

    /**
     * 删除部署流程
     */
    @Test
    public void testDeleteDeployment(){
        processEngine.getRepositoryService().deleteDeployment("15001", true);
    }



}
