package web.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.demo.model.TodoEntity;
import web.demo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {

    @Autowired private TodoRepository todoRepository;

    public String testService(){
        TodoEntity todoEntity = TodoEntity.builder().title("My first todo Item").build();
        todoRepository.save(todoEntity);
        TodoEntity savedEntity = todoRepository.findById(todoEntity.getId()).get();
        return savedEntity.getTitle();
    }

    public List<TodoEntity> create(final TodoEntity entity){
        validate(entity);

        todoRepository.save(entity);

        log.info("Entity id : {} is saved", entity.getId());

        return todoRepository.findByUserId(entity.getUserId());
    }

    private static void validate(TodoEntity entity) {
        if(entity == null){
            log.warn("entity cannot be null");
            throw new RuntimeException("Entity Cannot be null");
        }

        if(entity.getUserId() == null){
            log.warn("Unkown User");
            throw new RuntimeException("Unknown User");
        }
    }

    public List<TodoEntity> retrieve(final String userId){
        return todoRepository.findByUserId(userId);
    }

    public List<TodoEntity> update(final TodoEntity todoEntity){

        validate(todoEntity);

        final Optional<TodoEntity> original = todoRepository.findById(todoEntity.getId());

        original.ifPresent(todo -> {
            todo.setTitle(todoEntity.getTitle());
            todo.setDone(todo.isDone());

            todoRepository.save(todo);
        });

        return retrieve(todoEntity.getUserId());
    }

    public List<TodoEntity> delete(final TodoEntity entity){
        validate(entity);

        try{
            todoRepository.delete(entity);
        }catch(Exception e){
            log.error("error deleting entity", entity.getId(), e);

            throw new RuntimeException("error deleting entity" + entity.getId());
        }

        return retrieve(entity.getUserId());
    }

}
