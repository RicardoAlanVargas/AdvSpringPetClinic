package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;


/**
 * Created by Ricardo Vargas on 6/09/19.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
