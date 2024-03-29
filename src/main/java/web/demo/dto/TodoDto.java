package web.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.demo.model.TodoEntity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TodoDto {
    private String id;
    private String title;
    private boolean done;

    public TodoDto(final TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.done = todoEntity.isDone();
    }

    public static TodoEntity toEntity(final TodoDto dto){
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
