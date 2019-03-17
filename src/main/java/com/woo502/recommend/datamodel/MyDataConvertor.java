package com.woo502.recommend.datamodel;

import java.io.IOException;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.woo502.recommend.bo.Book;
import com.woo502.recommend.bo.BookStatistic;
import com.woo502.recommend.bo.CollectRecord;
import com.woo502.recommend.bo.ReadRecord;
import com.woo502.recommend.bo.ShareRecord;
import com.woo502.recommend.bo.User;

import net.librec.data.convertor.AbstractDataConvertor;
import net.librec.math.structure.SparseMatrix;

public class MyDataConvertor extends AbstractDataConvertor {
	
	List<User> userList = null;
	List<Book> bookList = null;
	List<ReadRecord> readList = null;
	List<ShareRecord> shareList = null;
	List<CollectRecord> collectList = null;
	List<BookStatistic> bookStatistics = null;
	/**
     * user/item {raw id, inner id} map
     */
    private BiMap<String, Integer> userIds, itemIds;
	private Double binThold;
	
	public MyDataConvertor(List<User> userList, List<Book> bookList, List<ReadRecord> readList,
			List<ShareRecord> shareList, List<CollectRecord> collectList, List<BookStatistic> bookStatistics,
			Double binThold) {
		this.userList = userList;
        this.bookList = bookList;
        this.readList = readList;
        this.shareList = shareList;
        this.collectList = collectList;
        this.bookStatistics = bookStatistics;
        this.binThold = binThold;
	}

	@Override
	public void processData() throws IOException {
        Table<Integer, Integer, Double> dataTable = HashBasedTable.create();
        // Map {col-id, multiple row-id}: used to fast build a rating matrix
        Multimap<Integer, Integer> colMap = HashMultimap.create();
		// TODO Auto-generated method stub
		if (this.userIds == null) {
            this.userIds = HashBiMap.create();
        }
        if (this.itemIds == null) {
            this.itemIds = HashBiMap.create();
        }
        
        // 把实例化对象转换为数据模型
        int readIdx = 0;
        Integer readUserId = readList.get(readIdx).getUserid();
        Integer readBookId = readList.get(readIdx).getBookid();
        byte readFinish = readList.get(readIdx).getType();
        
        int shareIdx = 0;
        Integer shareUserId = shareList.get(shareIdx).getUserid();
        Integer shareBookId = shareList.get(shareIdx).getBookid();
        
        int collectIdx = 0;
        Integer collectUserId = collectList.get(collectIdx).getUserid();
        Integer collectBookId = collectList.get(collectIdx).getBookid();
        
        for (User user:userList) {
        	Integer userId = user.getUserid();

            int statisticIdx = 0;
            Integer statisticsBookId = bookStatistics.get(statisticIdx).getBookid();
        	
        	for (Book book: bookList) {
        		Double rate = 0.1;
        		Long bookId = book.getBookid().longValue();
        		
        		if ((book.getTag() == 38 && user.getSex() == 2) 
        				|| (book.getTag() == 39 && user.getSex() == 1)) {
        			rate = 0.001;
        		}
        		
        		// 已读过
        		if (readBookId.longValue() == bookId.longValue()
        				&& readUserId.intValue() == userId.intValue()
        				) {
        			rate = readFinish == 1 ? 1.0 : 5;
        			readIdx++;
        			
        			if (readIdx < readList.size()) {
	        			readUserId = readList.get(readIdx).getUserid();
	        	        readBookId = readList.get(readIdx).getBookid();
        			} else {
        				readUserId = -1;
        				readBookId = -1;
        			}
        		}
        		
        		// 分享过
        		if (shareBookId.longValue() == bookId.longValue()
        				&& shareUserId.intValue() == userId.intValue()) {
        			rate = 5.5;
        			shareIdx++;
        			
        			if (shareIdx < shareList.size()) {
	        			shareUserId = shareList.get(shareIdx).getUserid();
	        	        shareBookId = shareList.get(shareIdx).getBookid();
        			} else {
        				shareUserId = -1;
        				shareBookId = -1;
        			}
        		}
        		
        		//收藏过
        		if (collectBookId.longValue() == bookId.longValue()
        				&& collectUserId.intValue() == userId.intValue()) {
        			rate = 6.0;
        			collectIdx++;
        			
        			if (collectIdx < collectList.size()) {
	        			collectUserId = collectList.get(collectIdx).getUserid();
	        	        collectBookId = collectList.get(collectIdx).getBookid();
        			} else {
        				collectUserId = -1;
        				collectBookId = -1;
        			}
        		}
        		
        		//阅读量
        		if (statisticsBookId.longValue() == bookId.longValue()) {
        			rate += bookStatistics.get(statisticIdx).getRead() / 1000d;
        			statisticIdx++;
        			
        			if (statisticIdx < collectList.size()) {
        				statisticsBookId = bookStatistics.get(statisticIdx).getBookid();
        			} else {
        				statisticsBookId = -1;
        			}
        		}
        		
        		if (binThold >= 0) {
                    rate = rate > binThold ? rate : 0.1;
                }
        		
        		int row = userIds.containsKey(userId.toString()) ? userIds.get(userId.toString()) : userIds.size();
                userIds.put(userId.toString(), row);

                int col = itemIds.containsKey(bookId.toString()) ? itemIds.get(bookId.toString()) : itemIds.size();
                itemIds.put(bookId.toString(), col);

                dataTable.put(row, col, rate);
                colMap.put(col, row);
        	}
        }
        
        int numRows = numUsers(), numCols = numItems();
        // build rating matrix
        preferenceMatrix = new SparseMatrix(numRows, numCols, dataTable, colMap);
        // release memory of data table
        dataTable = null;
	}

	@Override
	public void progress() {
		// TODO Auto-generated method stub
		getJobStatus().setProgress(0);
	}

	public int numUsers() {
        return userIds.size();
    }

    /**
     * Return the number of items.
     *
     * @return number of items
     */
    public int numItems() {
        return itemIds.size();
    }
    
    /**
     * Return a user's inner id by his raw id.
     *
     * @param rawId raw user id as String
     * @return inner user id as int
     */
    public int getUserId(String rawId) {
        return userIds.get(rawId);
    }

    /**
     * Return an item's inner id by its raw id.
     *
     * @param rawId raw item id as String
     * @return inner item id as int
     */
    public int getItemId(String rawId) {
        return itemIds.get(rawId);
    }

    /**
     * Return user {rawid, inner id} mappings
     *
     * @return {@link #userIds}
     */
    public BiMap<String, Integer> getUserIds() {
        return userIds;
    }

    /**
     * Return item {rawid, inner id} mappings
     *
     * @return {@link #itemIds}
     */
    public BiMap<String, Integer> getItemIds() {
        return itemIds;
    }
}
