package org.etiya.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    private int id;

    private int studentId;

    private int bookId;

    private Date startDate;

    private Date endDate;


}
