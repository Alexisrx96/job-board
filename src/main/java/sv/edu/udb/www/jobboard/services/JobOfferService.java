package sv.edu.udb.www.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.jobboard.models.dao.JobOfferDao;
import sv.edu.udb.www.jobboard.models.entities.JobOffer;

@Service
public class JobOfferService {
    @Autowired
    private JobOfferDao jobOfferDao;

    public JobOffer getJobOffer(int id){
        return jobOfferDao.getJobOffer(id);
    }
}
