package com.woo502.recommend.datamodel;

import java.io.IOException;
import java.util.List;

import com.google.common.collect.BiMap;
import com.woo502.recommend.bo.Book;
import com.woo502.recommend.bo.BookStatistic;
import com.woo502.recommend.bo.CollectRecord;
import com.woo502.recommend.bo.ReadRecord;
import com.woo502.recommend.bo.ShareRecord;
import com.woo502.recommend.bo.User;

import net.librec.common.LibrecException;
import net.librec.conf.Configuration;
import net.librec.data.model.AbstractDataModel;
import net.librec.math.structure.DataSet;

public class MyDataModel extends AbstractDataModel {
	
	List<User> userList = null;
	List<Book> bookList = null;
	List<ReadRecord> readList = null;
	List<ShareRecord> shareList = null;
	List<CollectRecord> collectList = null;
	List<BookStatistic> bookStatistics = null;

	public MyDataModel() {
    }

	public MyDataModel(Configuration conf, List<User> userList, List<Book> bookList, List<ReadRecord> readList,
			List<ShareRecord> shareList, List<CollectRecord> collectList, List<BookStatistic> bookStatistics) {
        this.conf = conf;
        this.userList = userList;
        this.bookList = bookList;
        this.readList = readList;
        this.shareList = shareList;
        this.collectList = collectList;
        this.bookStatistics = bookStatistics;
    }

    /**
     * Get user mapping data.
     *
     * @return the user {raw id, inner id} map of data model.
     */
    @Override
    public BiMap<String, Integer> getUserMappingData() {
        return ((MyDataConvertor) dataConvertor).getUserIds();
    }

    /**
     * Get item mapping data.
     *
     * @return the item {raw id, inner id} map of data model.
     */
    @Override
    public BiMap<String, Integer> getItemMappingData() {
        return ((MyDataConvertor) dataConvertor).getItemIds();
    }

    /**
     * Get datetime data set.
     *
     * @return the datetime data set of data model.
     */
    @Override
    public DataSet getDatetimeDataSet() {
        return ((MyDataConvertor) dataConvertor).getDatetimeMatrix();
    }

	@Override
	protected void buildConvert() throws LibrecException {
		dataConvertor = new MyDataConvertor(userList, bookList, readList, shareList, collectList, bookStatistics,
				conf.getDouble("data.convert.binarize.threshold", -1.0));
        try {
            dataConvertor.processData();
        } catch (IOException e) {
            throw new LibrecException(e);
        }
	}

}
