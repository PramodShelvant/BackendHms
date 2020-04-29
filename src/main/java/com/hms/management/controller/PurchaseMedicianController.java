package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.PurchaseMedicianBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PurchaseMedician;
import com.hms.management.serviceimpl.PurchaseMedicianServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/purchasemedician")
public class PurchaseMedicianController {

	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";
    @Autowired
	public PurchaseMedicianServiceImpl purchaseMedicianServiceImpl;
    
    
	@CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
     public Object addMedicianPurchase(PurchaseMedicianBean purchaseMedicianBean) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
		PurchaseMedician n=new PurchaseMedician();
        byte[] bytes = null;
		try {
			bytes = purchaseMedicianBean.getAttachDocument().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + purchaseMedicianBean.getAttachDocument().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setAttachDocument(UPLOADED_FOLDER + purchaseMedicianBean.getAttachDocument().getOriginalFilename());
        n.setMedicianCategory(purchaseMedicianBean.getMedicianCategory());
        n.setMedicianName(purchaseMedicianBean.getMedicianName());
        n.setBatchNo(purchaseMedicianBean.getBatchNo());
        n.setExpireDate(purchaseMedicianBean.getExpireDate());
        n.setMRP(purchaseMedicianBean.getMRP());
        n.setBatchAmount(purchaseMedicianBean.getBatchAmount());
        n.setSalePrice(purchaseMedicianBean.getSalePrice());
        n.setPackagingPrice(purchaseMedicianBean.getPackagingPrice());
        n.setPackagingQty(purchaseMedicianBean.getPackagingQty());
        n.setQuentity(purchaseMedicianBean.getQuentity());
        n.setAmount(purchaseMedicianBean.getAmount());
        n.setNote(purchaseMedicianBean.getNote());
        n.setTotal(purchaseMedicianBean.getTotal());
        n.setDiscount(purchaseMedicianBean.getDiscount());
        n.setTax(purchaseMedicianBean.getTax());
        n.setNetAmount(purchaseMedicianBean.getNetAmount());
        return purchaseMedicianServiceImpl.addPurchaseMedician(n);
		
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PurchaseMedician getMedicianById(@PathVariable int id) throws RecordNotFoundException {
 		return purchaseMedicianServiceImpl.getPurchaseMedician(id);
    }
    
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<PurchaseMedician> getAllMedicians() throws RecordNotFoundException {
 		return purchaseMedicianServiceImpl.getAllPurchaseMedician();
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePurchaseMedician(@PathVariable int id) {
		return purchaseMedicianServiceImpl.deletePurchaseMedician(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public PurchaseMedician adPurchaseMedician(@RequestBody PurchaseMedician PurchaseMedician) {
		return purchaseMedicianServiceImpl.adPurchaseMedician(PurchaseMedician);
		
	}
}
