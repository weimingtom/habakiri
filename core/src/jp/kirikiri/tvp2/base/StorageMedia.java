/**
 ******************************************************************************
 * Copyright (c), Takenori Imoto
 * 楓 software http://www.kaede-software.com/
 * All rights reserved.
 ******************************************************************************
 * ソースコード形式かバイナリ形式か、変更するかしないかを問わず、以下の条件を満
 * たす場合に限り、再頒布および使用が許可されます。
 *
 * ・ソースコードを再頒布する場合、上記の著作権表示、本条件一覧、および下記免責
 *   条項を含めること。
 * ・バイナリ形式で再頒布する場合、頒布物に付属のドキュメント等の資料に、上記の
 *   著作権表示、本条件一覧、および下記免責条項を含めること。
 * ・書面による特別の許可なしに、本ソフトウェアから派生した製品の宣伝または販売
 *   促進に、組織の名前またはコントリビューターの名前を使用してはならない。
 *
 * 本ソフトウェアは、著作権者およびコントリビューターによって「現状のまま」提供
 * されており、明示黙示を問わず、商業的な使用可能性、および特定の目的に対する適
 * 合性に関する暗黙の保証も含め、またそれに限定されない、いかなる保証もありませ
 * ん。著作権者もコントリビューターも、事由のいかんを問わず、損害発生の原因いか
 * んを問わず、かつ責任の根拠が契約であるか厳格責任であるか（過失その他の）不法
 * 行為であるかを問わず、仮にそのような損害が発生する可能性を知らされていたとし
 * ても、本ソフトウェアの使用によって発生した（代替品または代用サービスの調達、
 * 使用の喪失、データの喪失、利益の喪失、業務の中断も含め、またそれに限定されな
 * い）直接損害、間接損害、偶発的な損害、特別損害、懲罰的損害、または結果損害に
 * ついて、一切責任を負わないものとします。
 ******************************************************************************
 * 本ソフトウェアは、吉里吉里2 ( http://kikyou.info/tvp/ ) のソースコードをJava
 * に書き換えたものを一部使用しています。
 * 吉里吉里2 Copyright (C) W.Dee <dee@kikyou.info> and contributors
 ******************************************************************************
 */
package jp.kirikiri.tvp2.base;

import jp.kirikiri.tjs2.BinaryStream;
import jp.kirikiri.tjs2.TJSException;


public interface StorageMedia {

	/**
	 * returns media name like "file", "http" etc.
	 */
	public String getName();

	/**
	 * normalize domain name according with the media's rule
	 */
	public String normalizeDomainName( final String name );

	/**
	 * normalize path name according with the media's rule
	 * "name" below is normalized but does not contain media, eg.
	 * not "media://domain/path" but "domain/path"
	 */
	public String normalizePathName( final String name );

	public String getDefaultDomain();

	/**
	 * check file existence
	 * @throws TJSException
	 */
	public boolean checkExistentStorage( final String name ) throws TJSException;

	/**
	 * open a storage and return a tTJSBinaryStream instance.
	 * name does not contain in-archive storage name but
	 * is normalized.
	 * @throws TJSException
	 */
	public BinaryStream open( final String name, int flags ) throws TJSException;

	/**
	 * list files at given place
	 * @throws TJSException
	 */
	public void getListAt( final String name, StorageLister lister ) throws TJSException;

	/**
	 * basically the same as above,
	 * check wether given name is easily accessible from local OS filesystem.
	 * if true, returns local OS native name. otherwise returns an empty string.
	 */
	public String getLocallyAccessibleName( String name );
}
