package com.intbyte.wizbuddy.taskperchecklist.service;

import com.intbyte.wizbuddy.mapper.TaskPerCheckListMapper;
import com.intbyte.wizbuddy.taskperchecklist.domain.EditTaskPerCheckListInfo;
import com.intbyte.wizbuddy.taskperchecklist.domain.TaskPerCheckListMybatis;
import com.intbyte.wizbuddy.taskperchecklist.domain.entity.TaskPerChecklistId;
import com.intbyte.wizbuddy.taskperchecklist.dto.TaskPerCheckListDTO;
import com.intbyte.wizbuddy.user.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskPerCheckListServiceTests {

    @Autowired
    private TaskPerCheckListService taskPerCheckListService;
    @Autowired
    private TaskPerCheckListMapper taskPerCheckListMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("체크리스트에 업무추가 테스트 성공")
    public void insertTaskPerCheckListTest(){

//        UUID employeeCode = UUID.randomUUID(); -> 존재하지 않는 유저로 insert 하려고 해서 생긴 오류
        int size = employeeRepository.findAll().size();
        String employeeCode = employeeRepository.findAll().get(size-1).getEmployeeCode();

        TaskPerCheckListDTO taskPerCheckListDTO = new TaskPerCheckListDTO(1, 5, true,
                LocalDateTime.now(), LocalDateTime.now(), employeeCode);

        taskPerCheckListService.insertTaskPerCheckList(taskPerCheckListDTO);
    }

    @Test
    @DisplayName("체크리스트의 업무 조회 테스트 성공")
    public void findTaskPerCheckListByIdTest(){

        // given
        TaskPerChecklistId taskPerChecklistId = new TaskPerChecklistId(1, 1);

        // when
        TaskPerCheckListDTO taskPerCheckListDTO =
                taskPerCheckListService.findTaskPerCheckListById(taskPerChecklistId);

        System.out.println("taskPerCheckListDTO = " + taskPerCheckListDTO);

        // then
        assertNotNull(taskPerCheckListDTO);
    }

    @Test
    @DisplayName("체크리스트별 업무 전체 조회 테스트 성공")
    public void findAllTaskPerCheckListTest() {
        List<TaskPerCheckListDTO> allTaskPerCheckList = taskPerCheckListService.findAllTaskPerCheckList();
        for (int i = 0; i < allTaskPerCheckList.size(); i++) {
            System.out.println(allTaskPerCheckList.get(i));
        }
    }

    @Test
    @DisplayName("특정 체크리스트의 완료된 업무만 조회")
    @Transactional
    public void findAllTaskPerCheckListFinished(){

        Integer size = employeeRepository.findAll().size();
        String employeeCode = employeeRepository.findAll().get(size-1).getEmployeeCode();

        System.out.println("employeeCode = " + employeeCode);
        List<TaskPerCheckListDTO> finishedTask = taskPerCheckListService.findAllTaskPerCheckListFinished(employeeCode);
        System.out.println(finishedTask.size());
        for (int i = 0; i < finishedTask.size(); i++) {
            System.out.println(finishedTask.get(i));
            assertNotNull(finishedTask.get(i));
        }
    }

    // 1-1.
    @Test
    @DisplayName("특정 매장의 특정 체크리스트속 업무 조회")
    @Transactional
    public void findAllTaskPerCheckListByCheckListCodeTest(){
        assertDoesNotThrow(() -> {
            taskPerCheckListService.findAllTaskPerCheckListByCheckListCode(1);
        });
    }

    // 1-2.
    @Test
    @DisplayName("특정 매장의 특정 체크리스트속 완료된 업무 조회")
    @Transactional
    public void findAllTaskPerCheckListByCheckListCodeFinishedTest(){
        assertDoesNotThrow(() -> {
            taskPerCheckListService.findAllTaskPerCheckListByCheckListCodeByFinished(1);
        });
    }

    // 1-3.
    @Test
    @DisplayName("특정 매장의 특정 체크리스트속 완료된 업무 조회")
    @Transactional
    public void findAllTaskPerCheckListByCheckListCodeNotFinishedTest() {
        assertDoesNotThrow(() -> {
            taskPerCheckListService.findAllTaskPerCheckListByCheckListCodeByNotFinished(1);

        });
    }

    // 2. 특정 매장(특정 체크리스트)에 특정 업무 추가
    @Test
    @DisplayName("특정 매장의 특정 체크리스트에 특정 업무 추가")
    public void insertTaskPerCheckListByCheckList(){
        TaskPerCheckListDTO dto = new TaskPerCheckListDTO();
        dto.setCheckListCode(1);
        dto.setTaskCode(1);
        dto.setTaskFinishedState(true);
        dto.setUpdatedAt(LocalDateTime.now());
        dto.setEmployeeCode("20240831-07de-4b18-95c6-564cd86a5af2");

        assertDoesNotThrow(() -> {
            taskPerCheckListService.insertTaskPerCheckList(dto); // 고정 안된 task 추가하기
        });
    }

    // 3. 특정 매장(특정 체크리스트)의 특정 업무 finished 테스트
    @Test
    @DisplayName("수정 테스트")
    public void modifyTaskPerCheckList(){
        EditTaskPerCheckListInfo info = new EditTaskPerCheckListInfo();
        info.setCheckListCode(1);
        info.setTaskCode(1);
        info.setTaskFinishedState(false);
        info.setUpdatedAt(LocalDateTime.now());
        info.setEmployeeCode("20240831-1859-4c43-b692-b6cb5891c24a"); // 2번 회원으로 바꾸기

        assertDoesNotThrow(() -> {
            taskPerCheckListService.modifyTaskPerCheckList(info);
        });
    }

    // 4. 특정 매장의 특정 체크리스트의 특정 업무 삭제
    @Test
    @DisplayName("삭제 테스트")
    public void deleteTaskPerCheckListByCheckListCodeAndTaskCode() {
        assertDoesNotThrow(() -> {
            taskPerCheckListService.deleteTaskPerCheckListByCheckListCodeAndTaskCode(7, 9);
        });
    }
}