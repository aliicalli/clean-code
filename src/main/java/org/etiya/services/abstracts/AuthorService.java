package org.etiya.services.abstracts;

import org.etiya.core.services.GenericServices;
import org.etiya.entities.concretes.Author;

import java.util.List;

public interface AuthorService extends GenericServices<Author> {
    // Veri erişim katmanında işler (plain entity) saf veritabanı modellerinden geçerken
    // DTO, Request-Response Pattern, Result yapısı
}
