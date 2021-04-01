package tn.esprit.spring.service;

import tn.esprit.spring.entity.Rating;

public interface RatingService {

	public void addRatingByPubId(Rating rat,int idclient,Integer rating, int idpub);
}
