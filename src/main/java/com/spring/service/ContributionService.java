package com.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Contribution;
import com.spring.beans.FlashUser;
import com.spring.repository.ContributionRepository;
import com.spring.repository.FlashUserRepository;

@Service
public class ContributionService {

	@Autowired
	ContributionRepository contriRepo;

	@Autowired
	FlashUserRepository flashUserRepo;

	public void saveContribution(Contribution contri) {
		List<Contribution> existingContri = contriRepo.findByUserUniqueName(contri.getUserUniqueName());
		contri.setId((int) contriRepo.count() + 1);
		contriRepo.save(contri);

		System.out.println("=========================>" + existingContri.size());
		if (existingContri == null || existingContri.size() <= 0) {
			System.out.println("=========================>" + existingContri.size());
			FlashUser fu = new FlashUser();
			fu.setId((int) flashUserRepo.count() + 1);
			fu.setUserName(contri.getUserName());
			fu.setUserUniqueName(contri.getUserUniqueName());
			fu.setEmailId(contri.getEmailId());
			flashUserRepo.save(fu);
		}

	}

	public List<Contribution> getUserContributions(String emailId) {
		List<Contribution> list = new ArrayList<>();
		list = contriRepo.findByEmailId(emailId);
		return list;
	}

	public boolean approveContriById(int id) {
		Optional<Contribution> list = contriRepo.findById(id);
		if (list.isPresent()) {
			Contribution contri = list.get();
			contri.setContriStatus(true);
			contri.setApprovedDate(new Date());
			contriRepo.save(contri);
			return true;
		}
		return false;
	}

	public Contribution editContriById(int id) {
		Optional<Contribution> list = contriRepo.findById(id);
		if (list.isPresent()) {
			Contribution contri = list.get();
			return contri;
		}
		return null;
	}

	public boolean saveEditedContribution(Contribution contri) {
		Optional<Contribution> list = contriRepo.findById(contri.getId());
		if (list.isPresent()) {
			System.out.println("contriService found: " + list.get().getContriQuestion());
			Contribution actualContri = list.get();
			actualContri.setContriUpdateDate(new Date());
			actualContri.setContriDomain(contri.getContriDomain());
			actualContri.setContriTopic(contri.getContriTopic());
			actualContri.setContriQuestion(contri.getContriQuestion());
			actualContri.setContriAnswer(contri.getContriAnswer());
			actualContri.setContriStatus(contri.isContriStatus());
			if (contri.isContriStatus())
				actualContri.setApprovedDate(new Date());

			actualContri.setUserName(contri.getUserName());
			actualContri.setUserUniqueName(contri.getUserUniqueName());
			actualContri.setEmailId(contri.getEmailId());
			contriRepo.save(actualContri);
			return true;
		}
		return false;
	}
}
