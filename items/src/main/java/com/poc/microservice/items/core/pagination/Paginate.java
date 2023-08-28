package com.poc.microservice.items.core.pagination;

import com.poc.microservice.items.model.dto.pagination.Filter;
import com.poc.microservice.items.model.dto.pagination.PaginateData;
import com.poc.microservice.items.model.dto.pagination.Pagination;
import com.poc.microservice.items.util.Utils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de agrupar las operaciones de paginación
 */
public class Paginate {
    public static <T> PaginateData<T> paginate(Pagination pagination) {

        /** Paginación */

        Sort.Order sort = new Sort.Order(Sort.Direction.ASC, "id"); // Creamos un Sort.Order por defecto

        // Puedo meter el new Sort Order dentro de un List y puedo hacer ordenamiento por varias columnas
        if(pagination.getSort() != null) { // En caso que venga como parametro, lo sobre-escribimos
            Sort.Direction dir = pagination.getSort().get().getAsc() ? Sort.Direction.ASC : Sort.Direction.DESC; // Dirección que va a tener el ordenamiento
            sort = new Sort.Order(dir, pagination.getSort().get().getField()); // Campo a utilizar
        }

        // Aquí creamos la paginación
        Pageable pageable = PageRequest.of(
                pagination.getSkip(),  // Cuantos elementos me salto
                pagination.getTake() > 0 ? pagination.getTake() : 99999999, // Cuantos elementos tomo, si es 0 o -1 se tomaran todos los elementos
                Sort.by(sort) // Asignamos el ordenamiento a la paginación
        );

        /** Filtrado */

        Specification<T> spec = Specification.where(null); // Creamos una especificación vacia
        if(pagination.getFilters() != null) { // En caso que se envien los filtros (and) agregamos a la especificación
           spec = spec.and(Paginate.specification(pagination.getFilters().get(), true));
        }

        if(pagination.getOrFilters() != null) { // En caso que se envien los filtros (or) agregamos a la especificación
            spec = spec.or(Paginate.specification(pagination.getOrFilters().get(), false));
        }

        // Construimos nuestros datos de paginacion
        PaginateData<T> paginateData = new PaginateData<>();

        // Le seteamos los datos que necesitamos para trabajar
        paginateData.setPageable(pageable); // Asignamos paginacion
        paginateData.setSpecification(Optional.of(spec)); // Asignamos Specificaciones

        return paginateData;
    }

    public static <T> Specification<T> specification(List<Filter> filters, Boolean and) {
        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicateList = new ArrayList<>();
                filters.stream().forEach(filter -> {
                    if(filter.getOperation().toString().equalsIgnoreCase("equal")){
                       predicateList.add(builder.equal(root.get(filter.getField()), filter.getValue().get(0)));
                    } else if(filter.getOperation().toString().equalsIgnoreCase("not_equal")){
                        predicateList.add(builder.notEqual(root.get(filter.getField()), filter.getValue().get(0)));
                    } else if(filter.getOperation().toString().equalsIgnoreCase("in")){
                        predicateList.add(builder.like(root.get(filter.getField()),  "%" + filter.getValue().toString().toLowerCase() + "%"));
                    } else if(filter.getOperation().toString().equalsIgnoreCase("not_in")){
                        predicateList.add(builder.notLike(root.get(filter.getField()),  "%" + filter.getValue().toString().toLowerCase() + "%"));
                    }

                    if(Utils.isNumber(filter.getValue().get(0))) {
                        if (filter.getOperation().toString().equalsIgnoreCase("GREATER_THAN")) {
                            predicateList.add(builder.greaterThan(root.get(filter.getField()), filter.getValue().get(0)));
                        } else if (filter.getOperation().toString().equalsIgnoreCase("LESS_THAN")) {
                            predicateList.add(builder.lessThan(root.get(filter.getField()), filter.getValue().get(0)));
                        } else if (filter.getOperation().toString().equalsIgnoreCase("GREATER_THAN_EQUAL")) {
                            predicateList.add(builder.greaterThanOrEqualTo(root.get(filter.getField()), filter.getValue().get(0)));
                        }else if (filter.getOperation().toString().equalsIgnoreCase("LESS_THAN_EQUAL")) {
                            predicateList.add(builder.lessThanOrEqualTo(root.get(filter.getField()), filter.getValue().get(0)));
                        }
                    }
                });
                return and ?
                        builder.and(predicateList.toArray(new Predicate[0])) :
                        builder.or(predicateList.toArray(new Predicate[0]));
            }
        };
    }


}
