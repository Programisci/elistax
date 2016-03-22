package com.dubilowicz.elista.user.repository;

import com.dubilowicz.elista.user.ob.PlansDiaryOb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RaikPraca on 2016-03-22.
 */
public interface IPlansDiaryRepository extends JpaRepository<PlansDiaryOb,Long>{

}
