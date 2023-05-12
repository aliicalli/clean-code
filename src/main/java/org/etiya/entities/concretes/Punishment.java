package org.etiya.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Punishment {
    private int id;
    private int studentId;
    private int bookId;

    @Override
    public String toString() {
        return "Punishment{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", bookId=" + bookId +
                '}';
    }
}
