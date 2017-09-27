/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-12 LearningPatterns Inc.
 */


package com.catalog;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.util.MusicItem;

// Implementation of Catalog interface using ItemDAO
//@Component
public class JavaTunesCatalog implements Catalog {

	// Properties
   private ItemDAO dao;

   public JavaTunesCatalog(){} 
   
   private int maxSearchResults = 0;
   public void setMaxSearchResults(int maxIn) {
	maxSearchResults = maxIn;
   }
   public int getMaxSearchResults() { return maxSearchResults; }

	// Constructor - We require a JavaTunesCatalog to be initialized with a SearchUtility bean when created
	public JavaTunesCatalog(ItemDAO daoIn) {
		System.out.println("====>");
		dao = daoIn;
	}
	
	// Business methods

   public MusicItem findById(Long id) {
	   System.out.println("JavaTunesCatalog:findById - " + id);

      // delegate to the search bean
      return dao.get(id);
  }

   public Collection<MusicItem> findByKeyword(String keyword)  {

      // delegate to the search Bean, then trim the results
      Collection<MusicItem> mic=trim(dao.searchByArtistTitle(keyword));
      return mic;
   }

	// Simple method to trim the results collection down to a size of maxSearchResults
	// We only bother to do it for Lists because their is an easy method to do so, and that's adequate to test the lab
   private Collection<MusicItem> trim (Collection<MusicItem> results) {
	   Collection<MusicItem> ret = results;
	   if ( (maxSearchResults > 0) 
			&& (results.size() > maxSearchResults) 
			&& (results instanceof List) ) {
		   ret = ((List<MusicItem>)results).subList(0,maxSearchResults);
	   }
	   return ret;
   }
}
